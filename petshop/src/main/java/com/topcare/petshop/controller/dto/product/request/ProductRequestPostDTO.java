package com.topcare.petshop.controller.dto.product.request;

import com.topcare.petshop.controller.dto.product.response.ProductSpecificationResponseDTO;

import java.util.List;

public record ProductRequestPostDTO(

        String title,
        Long code,
        String description,
        String littleDescription,
        String brand,
        List<String> categories,
        List<ProductSpecificationResponseDTO> specifications,
        List<ProductVariantRequestPostDTO> variants

) {
}
