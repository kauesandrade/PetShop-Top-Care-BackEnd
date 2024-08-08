package com.topcare.petshop.service.image.product;

import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import com.topcare.petshop.controller.dto.image.ImageResponseDTO;
import com.topcare.petshop.entity.ProductImage;
import com.topcare.petshop.entity.ProductImage;
import com.topcare.petshop.repository.ProductImageRepository;
import com.topcare.petshop.service.image.ImageServiceInt;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductImageServiceImpl implements ImageServiceInt<ProductImage> {

    private final ProductImageRepository repository;

    @Override
    public ProductImage findImageById(Long id) throws Exception {
        Optional<ProductImage> optionalImage = repository.findById(id);

        if (optionalImage.isEmpty()) {
            throw new Exception("Imagem não encontrada!");
        }

        return optionalImage.get();
    }

    @Override
    public ImageResponseDTO findImageByIdToDTO(Long id) throws Exception {
        ProductImage image = findImageById(id);
        return image.toDTO();
    }

    @Override
    public ProductImage saveImage(ProductImage image) throws IOException {
        return repository.save(image);
    }

    @Override
    public ImageResponseDTO createImageFromDTO(ImageRequestDTO imageDTO) throws IOException {
        ProductImage newImage = new ProductImage(imageDTO);
        return saveImage(newImage).toDTO();
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
