package com.topcare.petshop.service.image;

import com.topcare.petshop.controller.dto.image.ImageRequestGetDTO;
import com.topcare.petshop.controller.dto.image.ImageRequestPostDTO;
import com.topcare.petshop.controller.dto.image.ImageRequestPutDTO;
import com.topcare.petshop.entity.Image;
import com.topcare.petshop.repository.image.ImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ImageImpl implements ImageInt {

    private final ImageRepository repository;

    public ImageImpl(ImageRepository repository) {
        this.repository = repository;
    }

    @Override
    public ImageRequestGetDTO findImageById(Long id) {
        Optional<Image> optionalImage = repository.findById(id);

        if (optionalImage.isPresent()) {
            Image image = optionalImage.get();
            return image.toDTO();
        } else {
            throw new RuntimeException("Imagem não encontrada com ID: " + id);
        }
    }

    @Override
    public Image createImage(ImageRequestPostDTO imageDTO) {
        Image newImage = new Image();
        newImage.setUrl(imageDTO.url());
        newImage.setDescription(imageDTO.description());

        return repository.save(newImage);
    }

    @Override
    public Image editImage(ImageRequestPutDTO imageDTO) {
        Optional<Image> optionalImage = repository.findById(imageDTO.id());

        if (optionalImage.isPresent()) {
            Image existingImage = optionalImage.get();

            if (imageDTO.url() != null) {
                existingImage.setUrl(imageDTO.url());
            }
            if (imageDTO.description() != null) {
                existingImage.setDescription(imageDTO.description());
            }

            return repository.save(existingImage);
        } else {
            throw new RuntimeException("Imagem não encontrada com ID: " + imageDTO.id());
        }
    }

    @Override
    public boolean deleteImageById(Long id) {
        Optional<Image> optionalImage = repository.findById(id);

        if (optionalImage.isPresent()) {
            repository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Imagem não encontrada com ID: " + id);
        }
    }
}
