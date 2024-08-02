package com.topcare.petshop.controller.dto.category.cateogoryGroup;

import com.topcare.petshop.entity.CategoryImage;
import com.topcare.petshop.entity.ProductCategory;

import java.util.List;

public record CategoryGroupRequestDTO(
        String title,
        List<ProductCategory> categories,
        CategoryImage image
) {
}
