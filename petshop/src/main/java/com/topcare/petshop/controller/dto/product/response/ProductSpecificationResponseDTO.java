package com.topcare.petshop.controller.dto.product.response;

import jakarta.persistence.Column;

public record ProductSpecificationResponseDTO(
        String title,
        String description
) {
}
