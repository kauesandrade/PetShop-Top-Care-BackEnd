package com.topcare.petshop.service.petshop;

import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import com.topcare.petshop.controller.dto.petshop.PetshopRequestDTO;
import com.topcare.petshop.controller.dto.petshop.PetshopResponseAllDTO;
import com.topcare.petshop.controller.dto.petshop.PetshopResponseByIdDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface PetshopServiceInt {

    public PetshopResponseByIdDTO getPetshopById(Long id);
    public List<PetshopResponseAllDTO> getAllPetshops();

    PetshopRequestDTO createPetshop(ImageRequestDTO image, PetshopRequestDTO dto) throws IOException;

    public PetshopRequestDTO editPetshop(Long id, PetshopRequestDTO dto) throws IOException;
    public void deletePetshop(Long id);

}
