package com.topcare.petshop.controller;

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
                    petshopService.getPetshopById(id), HttpStatus.OK);
            ) 
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
