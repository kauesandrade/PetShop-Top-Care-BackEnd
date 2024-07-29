package com.topcare.petshop.controller.image;

import com.topcare.petshop.controller.dto.image.ImageRequestGetDTO;
import com.topcare.petshop.controller.dto.image.ImageRequestPostDTO;
import com.topcare.petshop.controller.dto.image.ImageRequestPutDTO;
import com.topcare.petshop.entity.Image;
import com.topcare.petshop.service.image.ImageImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/image")
@AllArgsConstructor
public class ImageController {

    private final ImageImpl imageService;

    public ImageController(ImageImpl imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageRequestGetDTO> getImage(@PathVariable Long id) {
        return new ResponseEntity<>(imageService.findImageById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Image> createImage(@RequestBody ImageRequestPostDTO imageDTO) {
        return new ResponseEntity<>(imageService.createImage(imageDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Image> editImage(@PathVariable Long id, @RequestBody ImageRequestPutDTO imageDTO) {
        ImageRequestPutDTO updatedDTO = new ImageRequestPutDTO(id, imageDTO.url(), imageDTO.description());
        return new ResponseEntity<>(imageService.editImage(updatedDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        imageService.deleteImageById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


