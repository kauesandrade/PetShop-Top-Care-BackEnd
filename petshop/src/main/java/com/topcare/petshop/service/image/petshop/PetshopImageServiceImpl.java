package com.topcare.petshop.service.image.petshop;

import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import com.topcare.petshop.controller.dto.image.ImageResponseDTO;
import com.topcare.petshop.entity.PetshopImage;
import com.topcare.petshop.entity.PetshopImage;
import com.topcare.petshop.repository.PetImageRepository;
import com.topcare.petshop.repository.PetshopImageRepository;
import com.topcare.petshop.service.image.ImageServiceInt;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PetshopImageServiceImpl implements ImageServiceInt<PetshopImage> {

    private final PetshopImageRepository repository;

    @Override
    public PetshopImage findImageById(Long id) throws Exception {
        Optional<PetshopImage> optionalImage = repository.findById(id);

        if (optionalImage.isEmpty()) {
            throw new Exception("Imagem não encontrada!");
        }

        return optionalImage.get();
    }

    @Override
    public ImageResponseDTO findImageByIdToDTO(Long id) throws Exception {
        PetshopImage image = findImageById(id);
        return image.toDTO();
    }

    @Override
    public PetshopImage saveImage(PetshopImage image) throws IOException {
        return repository.save(image);
    }

    @Override
    public ImageResponseDTO createImageFromDTO(ImageRequestDTO imageDTO) throws IOException {
        PetshopImage newImage = new PetshopImage(imageDTO);
        return saveImage(newImage).toDTO();
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
