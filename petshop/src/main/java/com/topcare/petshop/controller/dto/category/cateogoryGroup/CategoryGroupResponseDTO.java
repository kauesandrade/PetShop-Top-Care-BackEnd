package com.topcare.petshop.controller.dto.category.cateogoryGroup;

import com.topcare.petshop.controller.dto.category.ProductCategoryResponseDTO;
import com.topcare.petshop.entity.CategoryImage;

import java.util.List;

public record CategoryGroupResponseDTO(

        Long id,
        String title,
        List<ProductCategoryResponseDTO> categories,
        CategoryImage image
) {
}
