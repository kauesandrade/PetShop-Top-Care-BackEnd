package com.topcare.petshop.controller;

import com.topcare.petshop.service.brand.BrandServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topcare/brand")
@AllArgsConstructor
public class BrandController {

    private final BrandServiceImpl service;

    @GetMapping("/{id}")
    public ResponseEntity getBrand(@PathVariable Long id){
        try {
            return new ResponseEntity(service.findBrandToDTO(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
