package com.topcare.petshop.service.image.petshop;

import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import com.topcare.petshop.controller.dto.image.ImageResponseDTO;
import com.topcare.petshop.entity.Image;
import com.topcare.petshop.entity.PetshopImage;
import com.topcare.petshop.repository.PetshopImageRepository;
import com.topcare.petshop.service.image.ImageServiceInt;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
public class PetshopImageServiceImpl implements ImageServiceInt {

    private final PetshopImageRepository repository;

    @Override
    public PetshopImage findImageById(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Imagem não encontrada!"));
    }

    @Override
    public ImageResponseDTO findImageByIdToDTO(Long id) throws Exception {
        return findImageById(id).toDTO();
    }

    @Override
    public PetshopImage saveImage(Image image) throws IOException {
        return repository.save((PetshopImage) image);
    }

    @Override
    public ImageResponseDTO createImageFromDTO(ImageRequestDTO imageDTO) throws IOException {
        PetshopImage image = new PetshopImage(imageDTO);
        return saveImage(image).toDTO();
    }

    @Override
    public ImageResponseDTO editImage(Long id, ImageRequestDTO imageDTO) throws Exception {
        PetshopImage image = findImageById(id);
        image.edit(imageDTO);
        return saveImage(image).toDTO();
    }

    @Override
    public void deleteImageById(Long id) throws Exception {
        findImageById(id);
        repository.deleteById(id);
    }
}
