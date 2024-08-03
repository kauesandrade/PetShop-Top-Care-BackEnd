package com.topcare.petshop.controller.dto.image;

public record ImageResponseDTO(
        String name,
        String type,
        Long size,
        String url
) {
}
