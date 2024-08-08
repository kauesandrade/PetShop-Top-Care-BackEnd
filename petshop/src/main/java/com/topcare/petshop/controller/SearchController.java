package com.topcare.petshop.controller;

import com.topcare.petshop.entity.ProductCategory;
import com.topcare.petshop.service.product.ProductServiceImpl;
import com.topcare.petshop.service.search.SearchServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("topcare/search")
@AllArgsConstructor
public class SearchController {

    private final ProductServiceImpl productService;

    @GetMapping("/product")
    public ResponseEntity searchProduct(@RequestParam String search,
                                        @RequestParam String orderBy,
                                        @RequestBody List<ProductCategory> productCategoryList){

            return new ResponseEntity(productService.searchProduct(search,
                    orderBy, productCategoryList), HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity test(@RequestBody List<ProductCategory> productCategoryList) throws Exception {
        return new ResponseEntity(productService.test(productCategoryList), HttpStatus.OK);
    }
}
