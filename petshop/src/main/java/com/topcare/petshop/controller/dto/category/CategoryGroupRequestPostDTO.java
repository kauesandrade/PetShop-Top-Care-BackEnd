package com.topcare.petshop.controller.dto.category;

import com.topcare.petshop.entity.CategoryImage;
import io.micrometer.common.KeyValues;

import java.util.List;

public record CategoryGroupRequestPostDTO(
        String title,
        List<String> categories,
        CategoryImage image
) {
}
