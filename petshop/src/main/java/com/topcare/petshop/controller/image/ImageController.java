package com.topcare.petshop.controller.image;

import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import com.topcare.petshop.service.image.ImageServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/topcare/image")
@AllArgsConstructor
public class ImageController {

    private final ImageServiceImpl imageService;

    @GetMapping("/{id}")
    public ResponseEntity getImage(@PathVariable Long id) {
        try{
            return new ResponseEntity<>(imageService.findImageByIdToDTO(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity createImage(ImageRequestDTO imageDTO) {
        try {
            return new ResponseEntity<>(imageService.createImageFromDTO(imageDTO), HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity editImage(@PathVariable Long id, @RequestBody ImageRequestDTO imageDTO) {
        try {
            return new ResponseEntity<>(imageService.editImage(id, imageDTO), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteImage(@PathVariable Long id) {
        try {
            imageService.deleteImageById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}


