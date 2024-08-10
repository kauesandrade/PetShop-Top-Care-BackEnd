package com.topcare.petshop.service.image.customer;

import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import com.topcare.petshop.controller.dto.image.ImageResponseDTO;
import com.topcare.petshop.entity.CustomerImage;
import com.topcare.petshop.entity.CustomerImage;
import com.topcare.petshop.entity.CustomerImage;
import com.topcare.petshop.entity.Image;
import com.topcare.petshop.repository.CustomerImageRepository;
import com.topcare.petshop.repository.CustomerImageRepository;
import com.topcare.petshop.service.image.ImageServiceInt;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerImageServiceImpl implements ImageServiceInt {

    private final CustomerImageRepository repository;

    @Override
    public CustomerImage findImageById(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Imagem não encontrada!"));
    }

    @Override
    public ImageResponseDTO findImageByIdToDTO(Long id) throws Exception {
        return findImageById(id).toDTO();
    }

    @Override
    public CustomerImage saveImage(Image image) throws IOException {
        return repository.save((CustomerImage) image);
    }

    @Override
    public ImageResponseDTO createImageFromDTO(ImageRequestDTO imageDTO) throws IOException {
        CustomerImage image = new CustomerImage(imageDTO);
        return saveImage(image).toDTO();
    }

    @Override
    public ImageResponseDTO editImage(Long id, ImageRequestDTO imageDTO) throws Exception {
        CustomerImage image = findImageById(id);
        image.edit(imageDTO);
        return saveImage(image).toDTO();
    }

    @Override
    public void deleteImageById(Long id) throws Exception {
        findImageById(id);
        repository.deleteById(id);
    }
}
