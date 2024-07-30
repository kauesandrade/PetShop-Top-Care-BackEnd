package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.category.CategoryResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

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

    public ProductCategory(String title) {
        setTitle(title);
    }

    public CategoryResponseDTO toDTO(){
        return new CategoryResponseDTO(
                getTitle()
        );
    }
}
