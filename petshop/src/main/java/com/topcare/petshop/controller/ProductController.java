package com.topcare.petshop.controller;


import com.topcare.petshop.controller.dto.product.request.ProductRequestPostDTO;
import com.topcare.petshop.entity.Product;
import com.topcare.petshop.service.product.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topcare/product")
@AllArgsConstructor
public class ProductController {

   private final ProductServiceImpl productService;


    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductRequestPostDTO productDTO) {

        productService.createProduct(productDTO);
        return new ResponseEntity<>("test", HttpStatus.CREATED);
    }
}
