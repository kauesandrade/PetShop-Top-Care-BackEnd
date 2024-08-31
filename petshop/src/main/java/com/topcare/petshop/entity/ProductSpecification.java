package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.product.response.page.ProductSpecificationResponsePageDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Representa uma especificação de um produto.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSpecification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Título da especificação.
     */
    @Column(nullable = false)
    private String title;

    /**
     * Descrição da especificação.
     */
    @Column(nullable = false)
    private String description;

    /**
     * Constrói uma ProductSpecification com título e descrição.
     *
     * @param title Título da especificação.
     * @param description Descrição da especificação.
     */
    public ProductSpecification(String title, String description) {
        setTitle(title);
        setDescription(description);
    }

    /**
     * Constrói uma ProductSpecification a partir de um DTO.
     *
     * @param productSpecificationResponseDTO DTO de especificação do produto.
     */
    public ProductSpecification(ProductSpecificationResponsePageDTO productSpecificationResponseDTO) {
        setTitle(productSpecificationResponseDTO.title());
        setDescription(productSpecificationResponseDTO.description());
    }

    /**
     * Converte a especificação de produto para um DTO.
     *
     * @return DTO da especificação de produto.
     */
    public ProductSpecificationResponsePageDTO toDTO() {
        return new ProductSpecificationResponsePageDTO(
                getId(),
                getTitle(),
                getDescription()
        );
    }
}
