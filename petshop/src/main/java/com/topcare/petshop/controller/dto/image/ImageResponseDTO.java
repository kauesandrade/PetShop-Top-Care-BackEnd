package com.topcare.petshop.controller.dto.image;

import java.io.InputStream;

public record ImageResponseDTO(
        String name,
        String type,
        Long size,
        byte[] file
) {
}
