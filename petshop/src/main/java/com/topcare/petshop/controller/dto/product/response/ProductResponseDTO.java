package com.topcare.petshop.controller.dto.product.response;

import com.topcare.petshop.entity.Brand;
import com.topcare.petshop.entity.ProductCategory;
import com.topcare.petshop.entity.ProductReview;
import com.topcare.petshop.entity.ProductSpecification;

import java.util.List;

public record ProductResponseDTO(
        Long code,
        String title,
        String description,
        String littleDescription,
        Brand brand,
        List<ProductSpecification> specifications,
        Double rating,
        List<ProductCategory> categories,
        List<ProductReview> reviews,
        List<ProductVariantResponseDTO> variants
) { }
