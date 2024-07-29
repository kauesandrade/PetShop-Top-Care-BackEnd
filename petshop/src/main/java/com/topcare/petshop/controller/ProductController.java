package com.topcare.petshop.controller;


import com.topcare.petshop.controller.dto.product.request.ProductRequestPostDTO;
import com.topcare.petshop.controller.dto.product.response.ProductResponseDTO;
import com.topcare.petshop.entity.Product;
import com.topcare.petshop.service.product.ProductServiceImpl;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("topcare/product")
@AllArgsConstructor
@Transactional
public class ProductController {

   private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }


    @GetMapping("/{code}")
   public ResponseEntity<ProductResponseDTO> findProductByCode(@PathVariable Long code){

       ProductResponseDTO product = productService.findProductByCode(code);

       if(product == null){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }

       return new ResponseEntity<>(product, HttpStatus.OK);
   }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestPostDTO productDTO) {

        ProductResponseDTO product = productService.createProduct(productDTO).toDTO();

        if(product == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(product, HttpStatus.CREATED);

    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable Long code) {
        Boolean delete = productService.deleteProductByCode(code);

        if(delete == false) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(delete, HttpStatus.OK);
    }


}
