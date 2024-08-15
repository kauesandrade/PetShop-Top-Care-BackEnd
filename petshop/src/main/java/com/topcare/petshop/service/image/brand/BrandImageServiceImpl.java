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

@Service
@AllArgsConstructor
public class BrandImageServiceImpl implements ImageServiceInt {

    private final BrandImageRepository repository;

    @Override
    public BrandImage findImageById(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Imagem não encontrada!"));
    }

    @Override
    public ImageResponseDTO findImageByIdToDTO(Long id) throws Exception {
        return findImageById(id).toDTO();
    }

    @Override
    public BrandImage saveImage(Image image) throws IOException {
        return repository.save((BrandImage) image);
    }

    @Override
    public ImageResponseDTO createImageFromDTO(ImageRequestDTO imageDTO) throws IOException {
        BrandImage image = new BrandImage(imageDTO);
        return saveImage(image).toDTO();
    }

    @Override
    public ImageResponseDTO editImage(Long id, ImageRequestDTO imageDTO) throws Exception {
        BrandImage image = findImageById(id);
        image.editFromDTO(imageDTO);
        return saveImage(image).toDTO();
    }

    @Override
    public void deleteImageById(Long id) throws Exception {
        findImageById(id);
        repository.deleteById(id);
    }
}
