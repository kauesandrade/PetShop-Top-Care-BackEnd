package com.topcare.petshop.controller.dto.category.cateogoryGroup;

import com.topcare.petshop.controller.dto.category.CategoryResponseDTO;
import com.topcare.petshop.entity.CategoryImage;

import java.util.List;

public record CategoryGroupResponseDTO(

        Long id,
        String title,
        List<CategoryResponseDTO> categories,
        CategoryImage image
) {
}
