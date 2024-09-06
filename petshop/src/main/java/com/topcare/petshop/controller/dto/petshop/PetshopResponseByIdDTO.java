package com.topcare.petshop.controller.dto.petshop;

import com.topcare.petshop.entity.PetshopAddress;
import com.topcare.petshop.entity.PetshopImage;
import com.topcare.petshop.entity.ServiceVariant;

import java.util.List;

public record PetshopResponseByIdDTO(

        PetshopImage image,
        String name,
        PetshopAddress petshopAddress,
        String ditancia,
        String openingHours,
        List<ServiceVariant> serviceVariants

) {
}
