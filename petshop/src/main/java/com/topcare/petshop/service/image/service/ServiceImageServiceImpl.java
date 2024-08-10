package com.topcare.petshop.service.image.service;

import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import com.topcare.petshop.controller.dto.image.ImageResponseDTO;
import com.topcare.petshop.entity.Image;
import com.topcare.petshop.entity.ServiceImage;
import com.topcare.petshop.repository.ServiceImageRepository;
import com.topcare.petshop.service.image.ImageServiceInt;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
public class ServiceImageServiceImpl implements ImageServiceInt {

    private final ServiceImageRepository repository;

    @Override
    public ServiceImage findImageById(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Imagem não encontrada!"));
    }

    @Override
    public ImageResponseDTO findImageByIdToDTO(Long id) throws Exception {
        return findImageById(id).toDTO();
    }

    @Override
    public ServiceImage saveImage(Image image) throws IOException {
        return repository.save((ServiceImage) image);
    }

    @Override
    public ImageResponseDTO createImageFromDTO(ImageRequestDTO imageDTO) throws IOException {
        ServiceImage image = new ServiceImage(imageDTO);
        return saveImage(image).toDTO();
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
