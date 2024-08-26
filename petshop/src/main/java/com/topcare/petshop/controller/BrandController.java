package com.topcare.petshop.controller;

import com.topcare.petshop.controller.dto.brand.BrandRequestDTO;
import com.topcare.petshop.service.brand.BrandServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("topcare/brand")
@AllArgsConstructor
public class BrandController {

    private final BrandServiceImpl service;

    @GetMapping
    public ResponseEntity getAllBrands() {
        return new ResponseEntity(service.findAllBrandsToDTO(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getBrand(@PathVariable Long id) {
        try {
            return new ResponseEntity(service.findBrandToDTO(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    // Tem q ser form-data p poder receber a imagem
    public ResponseEntity createBrand(@ModelAttribute BrandRequestDTO brand) {
        try {
            return new ResponseEntity(service.saveBrandFromDTO(brand), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    // Tem q ser form-data p poder receber a imagem
    public ResponseEntity editBrand(@PathVariable Long id, @ModelAttribute BrandRequestDTO brand) {
        try {
            return new ResponseEntity(service.editBrandFromDTO(id, brand), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBrand(@PathVariable Long id) {
        try {
            service.deleteBrand(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}
