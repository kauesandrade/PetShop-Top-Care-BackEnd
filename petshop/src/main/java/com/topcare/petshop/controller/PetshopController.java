package com.topcare.petshop.controller;

import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import com.topcare.petshop.controller.dto.petshop.PetshopRequestDTO;
import com.topcare.petshop.service.petshop.PetshopServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/topcare/petshop")
public class PetshopController {

    private PetshopServiceImpl petshopService;

    @GetMapping("/getPetshop/{id}")
    public ResponseEntity getPetshopById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(
                    petshopService.getPetshopById(id), HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity(
                    e.getMessage(), HttpStatus.BAD_REQUEST
            );
        }
    }

    @GetMapping("/getAllPetshops")
    public ResponseEntity getAllPetshops() {
        try {
            return new ResponseEntity<>(
                    petshopService.getAllPetshops(), HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity(
                    e.getMessage(), HttpStatus.BAD_REQUEST
            );
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE}, path = "/createPetshop")
    public ResponseEntity createPetshop(@RequestPart MultipartFile image, @RequestPart PetshopRequestDTO dto) {
        try {
            return new ResponseEntity<>(
                    petshopService.createPetshop(new ImageRequestDTO(image), dto), HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity(
                    e.getMessage(), HttpStatus.BAD_REQUEST
            );
        }
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE}, path = "/editPetshop/{id}")
    public ResponseEntity editPetshop(@PathVariable Long id, @RequestPart PetshopRequestDTO dto, @RequestPart MultipartFile image) {
        try {
            return new ResponseEntity<>(
                    petshopService.editPetshop(new ImageRequestDTO(image), id, dto), HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity(
                    e.getMessage(), HttpStatus.BAD_REQUEST
            );
        }
    }

    @DeleteMapping("/deletePetshop/{id}")
    public void deletePetshop(@PathVariable Long id) {
        petshopService.deletePetshop(id);
    }
}
