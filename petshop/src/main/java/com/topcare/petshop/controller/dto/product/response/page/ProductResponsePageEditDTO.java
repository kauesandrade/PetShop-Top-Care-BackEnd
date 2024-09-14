package com.topcare.petshop.controller.dto.product.response.page;

import com.topcare.petshop.controller.dto.brand.BrandResponseDTO;
import com.topcare.petshop.controller.dto.category.ProductCategoryResponseDTO;

import java.util.List;

public record ProductResponsePageEditDTO(
        Long code,
        String title,
        String description,
        String shortDescription,
        BrandResponseDTO brand,
        List<ProductSpecificationResponsePageDTO> specifications,
        Double rating,
        List<ProductCategoryResponseDTO> categories,
        List<ProductVariantResponsePageEditDTO> variants
) {
}
