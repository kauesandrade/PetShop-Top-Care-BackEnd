package com.topcare.petshop.controller.dto.petshop;

import com.topcare.petshop.entity.PetshopAddress;
import com.topcare.petshop.entity.ServiceVariant;

import java.util.List;

public record PetshopResponseByIdDTO(

        PetshopAddress petshopAddress,
        String ditancia,
        String openingHours,
        List<ServiceVariant> variants

) {
}
