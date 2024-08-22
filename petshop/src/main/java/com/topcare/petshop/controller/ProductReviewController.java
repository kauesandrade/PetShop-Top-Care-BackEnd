package com.topcare.petshop.controller;

import com.topcare.petshop.controller.dto.productReview.ProductReviewGetDTO;
import com.topcare.petshop.controller.dto.productReview.ProductReviewPostDTO;
import com.topcare.petshop.service.productReview.ProductReviewServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("topcare/productReview")
@AllArgsConstructor
@CrossOrigin("*")
public class ProductReviewController {

    private ProductReviewServiceImpl service;

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

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProductReview(@PathVariable Long id){
        try {
            service.deleteProductReview(id);
            return new ResponseEntity(
                    HttpStatus.OK
            );
        } catch (Exception e){
            return new ResponseEntity(
                    e.getMessage(), HttpStatus.BAD_REQUEST
            );
        }
    }
}
