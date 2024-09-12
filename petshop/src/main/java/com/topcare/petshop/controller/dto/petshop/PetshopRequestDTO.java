package com.topcare.petshop.controller.dto.petshop;

import com.topcare.petshop.controller.dto.address.AddressRequestDTO;
import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import com.topcare.petshop.entity.PetshopAddress;
import com.topcare.petshop.entity.ServiceVariant;

import java.util.List;

public record PetshopRequestDTO(

        String name,
        AddressRequestDTO address,
        String telephone,
        String openingHours,
        List<ServiceVariant> serviceVariant

) {
}
