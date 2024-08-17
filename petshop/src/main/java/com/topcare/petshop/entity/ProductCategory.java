package com.topcare.petshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.topcare.petshop.controller.dto.category.CategoryResponseDTO;
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
    private CategoryGroup categoryGroup;

    public ProductCategory(String title) {
        setTitle(title);
    }

    public CategoryResponseDTO toDTO(){
        return new CategoryResponseDTO(
                getTitle()
        );
    }
}
