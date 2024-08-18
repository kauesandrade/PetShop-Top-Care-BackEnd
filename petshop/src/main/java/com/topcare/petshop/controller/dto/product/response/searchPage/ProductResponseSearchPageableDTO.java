package com.topcare.petshop.controller.dto.product.response.searchPage;

import com.topcare.petshop.controller.dto.brand.BrandResponseDTO;
import com.topcare.petshop.controller.dto.category.ProductCategoryResponseDTO;


import java.util.List;

public record ProductResponseSearchPageableDTO(
        Long code,
        String title,
        Double price,
        Double discountPrice,
        Integer parcels,
        BrandResponseDTO brand,
        Double rating,
        List<ProductCategoryResponseDTO> categories
) {
}
