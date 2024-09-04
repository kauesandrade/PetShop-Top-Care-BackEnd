package com.topcare.petshop.controller.dto.petshop;

import com.topcare.petshop.entity.PetshopAddress;
import com.topcare.petshop.entity.PetshopImage;

public record PetshopRequestDTO(

        PetshopImage image,
        String name,
        PetshopAddress address,
        String telephone,
        String openingHours

) {
}
