package com.topcare.petshop.service.petshop;

import com.topcare.petshop.controller.dto.petshop.PetshopResponseByIdDTO;
import org.springframework.stereotype.Service;

@Service
public interface PetshopServiceInt {

    public PetshopResponseByIdDTO getPetshopById(Long id);
}
