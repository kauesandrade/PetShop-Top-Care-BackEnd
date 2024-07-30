package com.topcare.petshop.controller.dto.category;

import com.topcare.petshop.entity.CategoryImage;

import java.util.List;

public record CategoryGroupResponseDTO(

        String title,
        List<CategoryResponseDTO> categories,
        CategoryImage image
) {
}
