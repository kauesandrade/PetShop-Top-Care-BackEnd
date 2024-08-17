package com.topcare.petshop.controller.dto.product.response;

import com.topcare.petshop.controller.dto.brand.BrandResponseDTO;
import com.topcare.petshop.controller.dto.category.CategoryResponseDTO;
import com.topcare.petshop.controller.dto.review.ProductReviewResponseDTO;
import com.topcare.petshop.entity.ProductSpecification;

import java.util.List;

public record ProductResponseDTO(
        Long code,
        String title,
        String description,
        String shortDescription,
        BrandResponseDTO brand,
        List<ProductSpecification> specifications,
        Double rating,
        List<CategoryResponseDTO> categories,
        List<ProductReviewResponseDTO> reviews,
        List<ProductVariantResponseDTO> variants
) { }
