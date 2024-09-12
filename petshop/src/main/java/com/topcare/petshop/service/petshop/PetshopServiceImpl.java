package com.topcare.petshop.service.petshop;

import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import com.topcare.petshop.controller.dto.petshop.PetshopRequestDTO;
import com.topcare.petshop.controller.dto.petshop.PetshopResponseAllDTO;
import com.topcare.petshop.controller.dto.petshop.PetshopResponseByIdDTO;
import com.topcare.petshop.entity.*;
import com.topcare.petshop.repository.PetshopRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class PetshopServiceImpl implements PetshopServiceInt{

    private PetshopRepository petshopRepository;

    @Override
    public PetshopResponseByIdDTO getPetshopById(Long id) {
        Petshop petshop = petshopRepository.findById(id).get();
        return petshop.byIdToDTO();
    }

    @Override
    public List<PetshopResponseAllDTO> getAllPetshops() {
        List<Petshop> petshops = petshopRepository.findAll();
        return petshops.stream().map(Petshop::allToDTO).toList();
    }

    @Override
    public PetshopRequestDTO createPetshop(ImageRequestDTO image, PetshopRequestDTO dto) throws IOException {
        Petshop petshop = new Petshop();
        petshopRepository.save(insertValuesToNewPetshop(image, dto, petshop));
        return dto;
    }

    @Override
    public PetshopRequestDTO editPetshop(ImageRequestDTO image, Long id, PetshopRequestDTO dto) throws IOException {
        Petshop petshop = petshopRepository.findById(id).get();
        petshopRepository.save(insertValuesToNewPetshop(image, dto, petshop));
        return dto;
    }

    @Override
    public void deletePetshop(Long id) {
        petshopRepository.deleteById(id);
    }

    public Petshop insertValuesToNewPetshop(ImageRequestDTO image, PetshopRequestDTO dto, Petshop petshop) throws IOException {
        petshop.setImage(new PetshopImage(image));
        petshop.setName(dto.name());
        petshop.setAddress(new PetshopAddress(dto.address()));
        petshop.setTelephone(dto.telephone());
        petshop.setOpeningHours(dto.openingHours());
        petshop.setOfferedServices(dto.serviceVariant());
        return petshop;
    }
}
