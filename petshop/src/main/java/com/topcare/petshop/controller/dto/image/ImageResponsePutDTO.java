package com.topcare.petshop.controller.dto.image;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.web.multipart.MultipartFile;

public record ImageResponsePutDTO(
        Long id,
        String name,
        String type,
        Long size,
        String url
//        MultipartFile file
) {
}
