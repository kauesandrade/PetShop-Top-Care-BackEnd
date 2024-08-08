package com.topcare.petshop.service.image.customer;

import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import com.topcare.petshop.controller.dto.image.ImageResponseDTO;
import com.topcare.petshop.entity.CustomerImage;
import com.topcare.petshop.entity.CustomerImage;
import com.topcare.petshop.repository.CustomerImageRepository;
import com.topcare.petshop.service.image.ImageServiceInt;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerImageServiceImpl implements ImageServiceInt<CustomerImage> {

    private final CustomerImageRepository repository;

    @Override
    public CustomerImage findImageById(Long id) throws Exception {
        Optional<CustomerImage> optionalImage = repository.findById(id);

        if (optionalImage.isEmpty()) {
            throw new Exception("Imagem não encontrada!");
        }

        return optionalImage.get();
    }

    @Override
    public ImageResponseDTO findImageByIdToDTO(Long id) throws Exception {
        CustomerImage image = findImageById(id);
        return image.toDTO();
    }

    @Override
    public CustomerImage saveImage(CustomerImage image) throws IOException {
        return repository.save(image);
    }

    @Override
    public ImageResponseDTO createImageFromDTO(ImageRequestDTO imageDTO) throws IOException {
        CustomerImage newImage = new CustomerImage(imageDTO);
        return saveImage(newImage).toDTO();
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
