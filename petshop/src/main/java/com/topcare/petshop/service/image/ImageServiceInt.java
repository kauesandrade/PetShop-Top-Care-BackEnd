package com.topcare.petshop.service.image;


import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import com.topcare.petshop.controller.dto.image.ImageResponseDTO;
import com.topcare.petshop.entity.Image;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface ImageServiceInt {

    Image findImageById(Long id) throws Exception;
    ImageResponseDTO findImageByIdToDTO(Long id) throws Exception;

    Image saveImage(Image image) throws IOException;
    ImageResponseDTO createImageFromDTO(ImageRequestDTO imageDTO) throws IOException;

    ImageResponseDTO editImage(Long id, ImageRequestDTO imageDTO) throws Exception;

    void deleteImageById(Long id) throws Exception;
}


