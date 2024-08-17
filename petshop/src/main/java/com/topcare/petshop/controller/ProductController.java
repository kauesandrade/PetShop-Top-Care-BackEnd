package com.topcare.petshop.controller;

import com.topcare.petshop.controller.dto.product.request.ProductRequestPostDTO;
import com.topcare.petshop.controller.dto.product.response.ProductResponseDTO;
import com.topcare.petshop.service.product.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("topcare/product")
@CrossOrigin("*")
@AllArgsConstructor
public class ProductController {

   private final ProductServiceImpl productService;

   @CrossOrigin("*")
   @GetMapping("/{code}")   
   public ResponseEntity getProductByCode(@PathVariable Long code){

       try{
           return new ResponseEntity<>(productService.getProductByCode(code), HttpStatus.OK);
       }catch (Exception e){
           return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
       }
   }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody ProductRequestPostDTO productDTO) throws Exception {

        try{
            return new ResponseEntity<>(productService.createProduct(productDTO).toDTO(),
                    HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/{code}")
    public ResponseEntity<ProductResponseDTO> editProduct(@PathVariable Long code,
                                                          @RequestBody ProductRequestPostDTO productDTO){

       return new ResponseEntity<>(productService.editProduct(productDTO, code), HttpStatus.OK);
    }


    @DeleteMapping("/{code}")
    public ResponseEntity deleteProduct(@PathVariable Long code) {

        try{
            productService.deleteProductByCode(code);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }


}
