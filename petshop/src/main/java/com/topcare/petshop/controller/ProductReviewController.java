package com.topcare.petshop.controller;

import com.topcare.petshop.controller.dto.productReview.ProductReviewGetDTO;
import com.topcare.petshop.controller.dto.productReview.ProductReviewPostDTO;
import com.topcare.petshop.entity.ProductReview;
import com.topcare.petshop.service.productReview.ProductReviewServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productReview")
@AllArgsConstructor
public class ProductReviewController {

    private ProductReviewServiceImpl service;

    @GetMapping("/{id}")
    public ResponseEntity<List<ProductReviewGetDTO>> getProductReview(@PathVariable Long id) {
        try {
            return new ResponseEntity(
                    service.getProductReview(id), HttpStatus.OK
            );
        } catch (Exception e){
            return new ResponseEntity(
                    e.getMessage(), HttpStatus.BAD_REQUEST
            );
        }
    }

    @PostMapping
    public ResponseEntity createProductReview(@RequestBody ProductReviewPostDTO dto){
        try {
            return new ResponseEntity(
                    service.createProductReview(dto), HttpStatus.OK
            );
        } catch (Exception e){
            return new ResponseEntity(
                    e.getMessage(), HttpStatus.BAD_REQUEST
            );
        }
    }

}
