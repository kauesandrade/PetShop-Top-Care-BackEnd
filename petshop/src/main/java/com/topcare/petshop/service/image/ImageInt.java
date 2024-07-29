package com.topcare.petshop.service.image;


import com.topcare.petshop.controller.dto.image.ImageRequestGetDTO;
import com.topcare.petshop.controller.dto.image.ImageRequestPostDTO;
import com.topcare.petshop.controller.dto.image.ImageRequestPutDTO;
import com.topcare.petshop.entity.Image;
import org.springframework.stereotype.Service;

@Service
public interface ImageInt {

    ImageRequestGetDTO findImageById(Long id);

    Image createImage(ImageRequestPostDTO imageDTO);

    Image editImage(ImageRequestPutDTO imageDTO);

    boolean deleteImageById(Long id);
}


