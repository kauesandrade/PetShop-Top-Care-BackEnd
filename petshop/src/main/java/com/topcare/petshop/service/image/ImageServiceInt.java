package com.topcare.petshop.service.image;


import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import com.topcare.petshop.controller.dto.image.ImageResponseDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface ImageServiceInt {

    ImageResponseDTO findImageById(Long id) throws Exception;

    ImageResponseDTO createImage(ImageRequestDTO imageDTO) throws IOException;

    ImageResponseDTO editImage(Long id, ImageRequestDTO imageDTO) throws Exception;

    void deleteImageById(Long id) throws Exception;
}


