package com.topcare.petshop.service.image.product;

import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import com.topcare.petshop.controller.dto.image.ImageResponseDTO;
import com.topcare.petshop.entity.Image;
import com.topcare.petshop.entity.ProductImage;
import com.topcare.petshop.repository.ProductImageRepository;
import com.topcare.petshop.service.image.ImageServiceInt;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
public class ProductImageServiceImpl implements ImageServiceInt {

    private final ProductImageRepository repository;

    @Override
    public ProductImage findImageById(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Imagem não encontrada!"));
    }

    @Override
    public ImageResponseDTO findImageByIdToDTO(Long id) throws Exception {
        return findImageById(id).toDTO();
    }

    @Override
    public ProductImage saveImage(Image image) throws IOException {
        return repository.save((ProductImage) image);
    }

    @Override
    public ImageResponseDTO createImageFromDTO(ImageRequestDTO imageDTO) throws IOException {
        ProductImage image = new ProductImage(imageDTO);
        return saveImage(image).toDTO();
    }

    @Override
    public ImageResponseDTO editImage(Long id, ImageRequestDTO imageDTO) throws Exception {
        ProductImage image = findImageById(id);
        image.edit(imageDTO);
        return saveImage(image).toDTO();
    }

    @Override
    public void deleteImageById(Long id) throws Exception {
        findImageById(id);
        repository.deleteById(id);
    }
}
