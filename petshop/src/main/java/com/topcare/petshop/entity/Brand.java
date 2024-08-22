package com.topcare.petshop.entity;
import com.topcare.petshop.controller.dto.brand.BrandRequestDTO;
import com.topcare.petshop.controller.dto.brand.BrandResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(nullable = false)
    private BrandImage image;

    public Brand(BrandRequestDTO brand) throws IOException {
        this.name = brand.name();
        this.image = new BrandImage(brand.image());
    }

    public void edit(BrandRequestDTO brand) throws IOException {
        this.name = brand.name();
        this.image.editFromFile(brand.image());
    }
    public BrandResponseDTO toDTO() {
        return new BrandResponseDTO(
                getId(),
                getName()
        );
    }
}
