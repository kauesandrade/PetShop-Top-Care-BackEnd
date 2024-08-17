package com.topcare.petshop.controller.dto.product.response;

import com.topcare.petshop.controller.dto.brand.BrandResponseDTO;
import com.topcare.petshop.controller.dto.category.CategoryResponseDTO;


import java.util.List;

public record ProductResponseSearchPageableDTO(
        Long code,
        String title,
        Double price,
        Double discountPrice,
        Integer parcels,
        BrandResponseDTO brand,
        Double rating,
        List<CategoryResponseDTO> categories
) {
}
