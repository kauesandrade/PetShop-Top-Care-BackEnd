package com.topcare.petshop.controller.dto.product.request;

import com.topcare.petshop.entity.ProductImage;

import java.util.List;

public record ProductVariantRequestPostDTO(
        String variantTitle,
        Long variantCode,
        Double price,
        Integer amountStock,
        Double discount
//        List<ProductImage> images
        ) {
}
