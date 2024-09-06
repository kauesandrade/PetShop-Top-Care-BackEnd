package com.topcare.petshop.controller.dto.petshop;

import com.topcare.petshop.controller.dto.image.ImageResponseDTO;
import com.topcare.petshop.entity.PetshopAddress;
import com.topcare.petshop.entity.ServiceVariant;

import java.util.List;

public record PetshopResponseAllDTO(

        ImageResponseDTO image,
        String name,
        PetshopAddress petshopAddress,
        String telephone,
        String openingHours,
        List<ServiceVariant> serviceVariants

) {
}
