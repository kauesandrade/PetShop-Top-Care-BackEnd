package com.topcare.petshop.controller.dto.product.response;

import com.topcare.petshop.entity.ProductImage;

import java.util.List;

public record ProductVariantResponseDTO(
        String variantTitle,
        Long variantCode,
        Double price,
        Double discountPrice,
        Boolean stock,
        List<ProductImage> images
        ) { }
