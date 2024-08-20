package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.category.ProductCategoryResponseDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(nullable = false)
    private CategoryGroup categoryGroup;

    public ProductCategory(String title) {
        setTitle(title);
    }

    public ProductCategoryResponseDTO toDTO(){
        return new ProductCategoryResponseDTO(
                getId(),
                getTitle()
        );
    }
}
