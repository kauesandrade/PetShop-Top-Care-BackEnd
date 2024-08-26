package com.topcare.petshop.controller.dto.product.response.page;

import com.topcare.petshop.entity.ProductImage;

import java.util.List;

public record ProductVariantResponsePageDTO(
        String variantTitle,
        Long variantCode,
        Double price,
        Double discountPrice,
        Integer parcels,
        Boolean stock,
        List<ProductImage> images
        ) { }
