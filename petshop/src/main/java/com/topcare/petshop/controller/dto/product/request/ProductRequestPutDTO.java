package com.topcare.petshop.controller.dto.product.request;

public record ProductRequestPutDTO(
        Long productCode,
        ProductRequestPostDTO productRequestPostDTO
) {
}
