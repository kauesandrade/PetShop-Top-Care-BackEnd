package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.product.response.page.ProductSpecificationResponsePageDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSpecification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    public ProductSpecification(String title, String description) {
        setTitle(title);
        setDescription(description);
    }

    public ProductSpecification(ProductSpecificationResponsePageDTO productSpecificationResponseDTO) {
        setTitle(productSpecificationResponseDTO.title());
        setDescription(productSpecificationResponseDTO.description());
    }

    public ProductSpecificationResponsePageDTO toDTO() {
        return new ProductSpecificationResponsePageDTO(
                getTitle(),
                getDescription()
        );
    }
}
