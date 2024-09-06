package com.topcare.petshop.controller.dto.petshop;

import com.topcare.petshop.controller.dto.image.ImageResponseDTO;
import com.topcare.petshop.entity.PetshopAddress;
import com.topcare.petshop.entity.PetshopImage;
import com.topcare.petshop.entity.ServiceVariant;

import java.util.List;

public record PetshopResponseByIdDTO(

        ImageResponseDTO image,
        String name,
        PetshopAddress petshopAddress,
        String ditancia,
        String openingHours,
        List<ServiceVariant> serviceVariants

) {
}
