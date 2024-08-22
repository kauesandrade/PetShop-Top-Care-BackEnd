package com.topcare.petshop.controller.image.pet;

import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import com.topcare.petshop.service.image.pet.PetImageServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/topcare/image/pet")
@AllArgsConstructor
public class PetImageController {

    private final PetImageServiceImpl service;

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
    public ResponseEntity createImage(@ModelAttribute ImageRequestDTO imageDTO) {
        try {
            return new ResponseEntity<>(service.createImageFromDTO(imageDTO), HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity editImage(@PathVariable Long id, @ModelAttribute ImageRequestDTO imageDTO) {
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


