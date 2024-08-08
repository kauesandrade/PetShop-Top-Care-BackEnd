package com.topcare.petshop.service.image;

import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import com.topcare.petshop.controller.dto.image.ImageResponseDTO;
import com.topcare.petshop.entity.Image;
import com.topcare.petshop.repository.ImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageServiceInt<Image> {

    private final ImageRepository repository;

    @Override
    public Image findImageById(Long id) throws Exception {
        Optional<Image> optionalImage = repository.findById(id);

        if (optionalImage.isEmpty()) {
            throw new Exception("Imagem não encontrada!");
        }

        return optionalImage.get();
    }

    @Override
    public ImageResponseDTO findImageByIdToDTO(Long id) throws Exception {
        Image image = findImageById(id);
        return image.toDTO();
    }

    @Override
    public Image saveImage(Image image) throws IOException {
        return repository.save(image);
    }

    @Override
    public ImageResponseDTO createImageFromDTO(ImageRequestDTO imageDTO) throws IOException {
        Image newImage = new Image(imageDTO);
        return saveImage(newImage).toDTO();
    }

    @Override
    public ImageResponseDTO editImage(Long id, ImageRequestDTO imageDTO) throws Exception {
        Image image = findImageById(id);
        image.edit(imageDTO);
        return saveImage(image).toDTO();
    }

    @Override
    public void deleteImageById(Long id) throws Exception {
        findImageById(id);
        repository.deleteById(id);
    }
}
