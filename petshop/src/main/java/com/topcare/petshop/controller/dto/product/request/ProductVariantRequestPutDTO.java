package com.topcare.petshop.controller.dto.product.request;

import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import com.topcare.petshop.controller.dto.image.ImageResponsePutDTO;

import java.lang.reflect.Array;
import java.util.List;

public record ProductVariantRequestPutDTO(
        Long variantId,
        String variantTitle,
        Long variantCode,
        Double price,
        Double discount,
        Integer stock,
        List<ImageResponsePutDTO> images
) {
}
