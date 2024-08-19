package com.topcare.petshop.controller;
import com.topcare.petshop.controller.dto.search.SearchRequestDTO;
import com.topcare.petshop.service.product.ProductServiceImpl;
import com.topcare.petshop.service.service.ServiceServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("topcare/search")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class SearchController {

    private final ProductServiceImpl productService;
    private final ServiceServiceImpl serviceService;

    @PutMapping("/product")
    public ResponseEntity searchProduct(@RequestParam(required = false) String searchValue,
                                        @RequestParam(required = false) String sortBy,
                                        @RequestParam(defaultValue = "0") Integer page,
                                        @RequestParam(defaultValue = "10") Integer size,
                                        @RequestBody(required = false) List<Long> productCategories) throws Exception {


        SearchRequestDTO searchDTO =
                new SearchRequestDTO(searchValue, sortBy, page, size);

        return new ResponseEntity(productService.searchProduct(searchDTO, productCategories), HttpStatus.OK);

    }

    @GetMapping("/service")
    public ResponseEntity searchService(@RequestParam(required = false) String searchValue,
                                        @RequestParam(required = false) String sortBy,
                                        @RequestParam(defaultValue = "0") Integer page,
                                        @RequestParam(defaultValue = "10") Integer size){

        SearchRequestDTO searchDTO =
                new SearchRequestDTO(searchValue, sortBy, page, size);

        return new ResponseEntity(serviceService.searchService(searchDTO), HttpStatus.OK);
    }

}
