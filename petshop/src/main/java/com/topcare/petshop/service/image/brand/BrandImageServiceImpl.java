package com.topcare.petshop.service.image.brand;

import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import com.topcare.petshop.controller.dto.image.ImageResponseDTO;
import com.topcare.petshop.entity.BrandImage;
import com.topcare.petshop.entity.Image;
import com.topcare.petshop.repository.BrandImageRepository;
import com.topcare.petshop.service.image.ImageServiceInt;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandImageServiceImpl implements ImageServiceInt<BrandImage> {

    private final BrandImageRepository repository;

    @Override
    public BrandImage findImageById(Long id) throws Exception {
        Optional<BrandImage> optionalImage = repository.findById(id);

        if (optionalImage.isEmpty()) {
            throw new Exception("Imagem não encontrada!");
        }

        return optionalImage.get();
    }

    @Override
    public ImageResponseDTO findImageByIdToDTO(Long id) throws Exception {
        BrandImage image = findImageById(id);
        return image.toDTO();
    }

    @Override
    public BrandImage saveImage(BrandImage image) throws IOException {
        return repository.save(image);
    }

    @Override
    public ImageResponseDTO createImageFromDTO(ImageRequestDTO imageDTO) throws IOException {
        BrandImage newImage = new BrandImage(imageDTO);
        return saveImage(newImage).toDTO();
    }

    @Override
    public ImageResponseDTO editImage(Long id, ImageRequestDTO imageDTO) throws Exception {
        BrandImage image = findImageById(id);
        image.edit(imageDTO);
        return saveImage(image).toDTO();
    }

    @Override
    public void deleteImageById(Long id) throws Exception {
        findImageById(id);
        repository.deleteById(id);
    }
}
