package com.topcare.petshop.controller.image.service;

import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import com.topcare.petshop.service.image.service.ServiceImageServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/topcare/image/service")
@AllArgsConstructor
public class ServiceImageController {

    private final ServiceImageServiceImpl service;

    @GetMapping("/{id}")

    public ResponseEntity getImage(@PathVariable Long id) {
        try{
            return new ResponseEntity<>(service.findImageByIdToDTO(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity createImage(ImageRequestDTO imageDTO) {
        try {
            return new ResponseEntity<>(service.createImageFromDTO(imageDTO), HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity editImage(@PathVariable Long id, ImageRequestDTO imageDTO) {
        try {
            return new ResponseEntity<>(service.editImage(id, imageDTO), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteImage(@PathVariable Long id) {
        try {
            service.deleteImageById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}


