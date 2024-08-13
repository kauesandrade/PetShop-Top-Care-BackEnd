package com.topcare.petshop.controller;

import com.topcare.petshop.controller.dto.SearchResquestDTO;
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
    public ResponseEntity searchProduct(@RequestParam(required = false) String search,
                                        @RequestParam(required = false) String sortBy,
                                        @RequestParam(defaultValue = "0") Integer page,
                                        @RequestParam(defaultValue = "10") Integer size,
                                        @RequestBody(required = false) List<Long> productCategoryList){


        SearchResquestDTO searchDTO =
                new SearchResquestDTO(search, sortBy, page, size, productCategoryList);

        return new ResponseEntity(productService.searchProduct(searchDTO), HttpStatus.OK);

    }

//    @GetMapping("/test")
//    public ResponseEntity test(@RequestBody List<Long> productCategoryList) {
//        productService.getProductByProductCategoryId(productCategoryList);
//        return new ResponseEntity(HttpStatus.OK);
//    }
}
