package com.topcare.petshop.controller.dto.petshop;

import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import com.topcare.petshop.controller.dto.image.ImageResponseDTO;
import com.topcare.petshop.entity.PetshopAddress;
import com.topcare.petshop.entity.ServiceVariant;

import java.util.List;

public record PetshopAllAtributesDTO(

        ImageResponseDTO image,
        String name,
        PetshopAddress address,
        String telephone,
        String openingHours,
        List<ServiceVariant> serviceVariant

) {
}
