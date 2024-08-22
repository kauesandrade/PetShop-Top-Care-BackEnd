package com.topcare.petshop.controller.dto.category;

public record ProductCategoryResponseDTO(
        Long id,
        String title,
        boolean isChecked
) {
}
