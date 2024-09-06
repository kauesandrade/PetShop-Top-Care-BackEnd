package com.topcare.petshop.controller.dto.petshop;

import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import com.topcare.petshop.entity.PetshopAddress;
import com.topcare.petshop.entity.PetshopImage;
import com.topcare.petshop.entity.ServiceVariant;

import java.util.List;

public record PetshopRequestDTO(

        ImageRequestDTO image,
        String name,
        PetshopAddress address,
        String telephone,
        String openingHours,
        List<ServiceVariant> serviceVariant

) {
}
