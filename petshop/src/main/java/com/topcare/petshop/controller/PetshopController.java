package com.topcare.petshop.controller;

import com.topcare.petshop.controller.dto.petshop.PetshopRequestDTO;
import com.topcare.petshop.service.petshop.PetshopServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/topcare/petshop")
public class PetshopController {

    private PetshopServiceImpl petshopService;

    @GetMapping("/{id}")
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

    @GetMapping
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

    @PostMapping
    public ResponseEntity createPetshop(@RequestBody PetshopRequestDTO dto) {
        try {
            return new ResponseEntity<>(
                    petshopService.createPetshop(dto), HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity(
                    e.getMessage(), HttpStatus.BAD_REQUEST
            );
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity editPetshop(@PathVariable Long id, @RequestBody PetshopRequestDTO dto) {
        try {
            return new ResponseEntity<>(
                    petshopService.createPetshop(id, dto), HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity(
                    e.getMessage(), HttpStatus.BAD_REQUEST
            );
        }
    }

    @DeleteMapping("/{id}")
    public void deletePetshop(@PathVariable Long id) {
        petshopService.deletePetshop(id);
    }
}
