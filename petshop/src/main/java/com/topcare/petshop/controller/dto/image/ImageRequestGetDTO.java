package com.topcare.petshop.controller.dto.image;

public record ImageRequestGetDTO(
        Long id,
        String url,
        String description
) {
}
