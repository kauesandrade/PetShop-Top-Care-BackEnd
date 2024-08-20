package com.topcare.petshop.controller.dto.product.response.card;

import com.topcare.petshop.controller.dto.brand.BrandResponseDTO;
import com.topcare.petshop.entity.Image;
import com.topcare.petshop.entity.ProductImage;

public record ProductResponseCardDTO(
        Long code,
        Long variantCode,
        String title,
        BrandResponseDTO brand,
        Double price,
        Double discountPrice,
        Integer parcels,
        Double rating,
        ProductImage image
) {
}
