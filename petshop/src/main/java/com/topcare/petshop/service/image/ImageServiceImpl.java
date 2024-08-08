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
public class ImageServiceImpl implements ImageServiceInt {

    private final ImageRepository repository;

    @Override
    public ImageResponseDTO findImageById(Long id) throws Exception {
        Optional<Image> optionalImage = repository.findById(id);

        if (optionalImage.isPresent()) {
            Image image = optionalImage.get();
            return image.toDTO();
        } else {
            throw new Exception("Imagem não encontrada!");
        }
    }

    @Override
    public ImageResponseDTO createImage(ImageRequestDTO imageDTO) throws IOException {
        Image newImage = new Image(imageDTO);
        return repository.save(newImage).toDTO();
    }

    @Override
    public ImageResponseDTO editImage(Long id, ImageRequestDTO imageDTO) throws Exception {
        Optional<Image> optionalImage = repository.findById(id);

        if (optionalImage.isEmpty()) {
            throw new Exception("Imagem não encontrada");
        }

        Image image = optionalImage.get();
        image.edit(imageDTO);

        return repository.save(image).toDTO();

    }

    @Override
    public void deleteImageById(Long id) throws Exception {
        Optional<Image> optionalImage = repository.findById(id);

        if (optionalImage.isPresent()) {
            throw new Exception("Imagem não encontrada");
        }

        repository.deleteById(id);
    }
}
