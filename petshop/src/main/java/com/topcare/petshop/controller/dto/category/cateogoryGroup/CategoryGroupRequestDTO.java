package com.topcare.petshop.controller.dto.category.cateogoryGroup;

import com.topcare.petshop.entity.CategoryImage;

import java.util.List;

public record CategoryGroupRequestDTO(
        String title,
        List<String> categories,
        CategoryImage image
) {
}
