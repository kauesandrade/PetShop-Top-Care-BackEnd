package com.topcare.petshop.controller.dto.product.response.page;

import com.topcare.petshop.entity.ProductImage;

import java.util.List;

public record ProductVariantResponsePageEditDTO(

        Long variantId,
        String variantTitle,
        Long variantCode,
        Double price,
        Double discountPrice,
        Integer stock,
        List<ProductImage> images
) {
}
