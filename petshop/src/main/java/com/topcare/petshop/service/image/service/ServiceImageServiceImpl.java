package com.topcare.petshop.service.image.service;

import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import com.topcare.petshop.controller.dto.image.ImageResponseDTO;
import com.topcare.petshop.entity.ServiceImage;
import com.topcare.petshop.repository.ServiceImageRepository;
import com.topcare.petshop.service.image.ImageServiceInt;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceImageServiceImpl implements ImageServiceInt<ServiceImage> {

    private final ServiceImageRepository repository;

    @Override
    public ServiceImage findImageById(Long id) throws Exception {
        Optional<ServiceImage> optionalImage = repository.findById(id);

        if (optionalImage.isEmpty()) {
            throw new Exception("Imagem não encontrada!");
        }

        return optionalImage.get();
    }

    @Override
    public ImageResponseDTO findImageByIdToDTO(Long id) throws Exception {
        ServiceImage image = findImageById(id);
        return image.toDTO();
    }

    @Override
    public ServiceImage saveImage(ServiceImage image) throws IOException {
        return repository.save(image);
    }

    @Override
    public ImageResponseDTO createImageFromDTO(ImageRequestDTO imageDTO) throws IOException {
        ServiceImage newImage = new ServiceImage(imageDTO);
        return saveImage(newImage).toDTO();
    }

    @Override
    public ImageResponseDTO editImage(Long id, ImageRequestDTO imageDTO) throws Exception {
        ServiceImage image = findImageById(id);
        image.edit(imageDTO);
        return saveImage(image).toDTO();
    }

    @Override
    public void deleteImageById(Long id) throws Exception {
        findImageById(id);
        repository.deleteById(id);
    }
}
