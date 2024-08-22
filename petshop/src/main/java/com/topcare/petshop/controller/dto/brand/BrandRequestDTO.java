package com.topcare.petshop.controller.dto.brand;

import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import org.springframework.web.multipart.MultipartFile;

public record BrandRequestDTO(String name, MultipartFile image) {
}
