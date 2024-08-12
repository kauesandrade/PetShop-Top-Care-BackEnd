package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.brand.BrandResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(nullable = false)
    private BrandImage image;

    public BrandResponseDTO toDTO() {
        return new BrandResponseDTO(this.name, this.image.toDTO());
    }
}
