package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.category.ProductCategoryResponseDTO;
import jakarta.persistence.*;
import lombok.*;
/**
 * Representa uma categoria de produto.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Título da categoria.
     */
    @Column(nullable = false)
    private String title;

    /**
     * Grupo de categorias ao qual esta categoria pertence.
     */
    @ManyToOne
    @JoinColumn(nullable = false)
    private CategoryGroup categoryGroup;

    /**
     * Constrói uma ProductCategory a partir do título.
     *
     * @param title Título da categoria.
     */
    public ProductCategory(String title) {
        setTitle(title);
    }

    /**
     * Converte a categoria de produto para um DTO.
     *
     * @return DTO da categoria de produto.
     */
    public ProductCategoryResponseDTO toDTO(){
        return new ProductCategoryResponseDTO(
                getId(),
                getTitle()
        );
    }
}
