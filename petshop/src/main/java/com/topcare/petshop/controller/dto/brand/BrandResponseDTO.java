package com.topcare.petshop.controller.dto.brand;

import com.topcare.petshop.controller.dto.image.ImageResponseDTO;

public record BrandResponseDTO(String name, ImageResponseDTO image) {
}
