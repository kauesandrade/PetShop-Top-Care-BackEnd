package com.topcare.petshop.controller.dto.image;

public record ImageRequestPutDTO(
        Long id,
        String url,
        String description
) {
}
