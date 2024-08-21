package com.topcare.petshop.controller.dto.category.cateogoryGroup;

import com.topcare.petshop.controller.dto.category.ProductCategoryResponseDTO;

import java.util.List;

public record CategoryGroupFiltersResponseDTO(
        String title,
        List<ProductCategoryResponseDTO> categories
) {
}
