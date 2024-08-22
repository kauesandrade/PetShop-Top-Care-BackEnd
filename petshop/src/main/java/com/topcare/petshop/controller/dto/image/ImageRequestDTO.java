package com.topcare.petshop.controller.dto.image;

import org.springframework.web.multipart.MultipartFile;

public record ImageRequestDTO(
        MultipartFile file
) {
}
