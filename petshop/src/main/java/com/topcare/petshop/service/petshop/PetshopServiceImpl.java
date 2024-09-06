package com.topcare.petshop.service.petshop;

import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import com.topcare.petshop.controller.dto.petshop.PetshopRequestDTO;
import com.topcare.petshop.controller.dto.petshop.PetshopResponseAllDTO;
import com.topcare.petshop.controller.dto.petshop.PetshopResponseByIdDTO;
import com.topcare.petshop.entity.Petshop;
import com.topcare.petshop.entity.PetshopAddress;
import com.topcare.petshop.entity.PetshopImage;
import com.topcare.petshop.entity.ServiceVariant;
import com.topcare.petshop.repository.PetshopRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
    public PetshopRequestDTO createPetshop(PetshopRequestDTO dto) throws IOException {
        Petshop petshop =  new Petshop();
        insertValuesToNewPetshop(dto);
        petshopRepository.save(petshop);
        //muda essa bomba
        return dto;
    }

    @Override
    public PetshopRequestDTO editPetshop(Long id, PetshopRequestDTO dto) {
        return null;
    }

    @Override
    public void deletePetshop(Long id) {
        petshopRepository.deleteById(id);
    }

    public Petshop insertValuesToNewPetshop(PetshopRequestDTO dto) throws IOException {
        Petshop petshop = Petshop.builder()
                .image(new PetshopImage(dto.image()))
                .name(dto.name())
                .address(dto.address())
                .telephone(dto.telephone())
                .openingHours(dto.openingHours())
                .offeredServices(dto.serviceVariant())
                .build();
        return petshop;
    }
}
