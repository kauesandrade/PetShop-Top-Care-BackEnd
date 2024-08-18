package com.topcare.petshop.controller;

import com.topcare.petshop.controller.dto.search.SearchResquestDTO;
import com.topcare.petshop.entity.Product;
import com.topcare.petshop.service.product.ProductServiceImpl;
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

    @PutMapping("/product")
    public ResponseEntity searchProduct(@RequestParam(required = false) String search,
                                        @RequestParam(required = false) String sortBy,
                                        @RequestParam(defaultValue = "0") Integer page,
                                        @RequestParam(defaultValue = "10") Integer size,
                                        @RequestBody(required = false) List<Long> productCategories){


        SearchResquestDTO searchDTO =
                new SearchResquestDTO(search, sortBy, page, size, productCategories);

        return new ResponseEntity(productService.searchProduct(searchDTO), HttpStatus.OK);
    }
    
}
