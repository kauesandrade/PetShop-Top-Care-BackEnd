package com.topcare.petshop.controller;


import com.topcare.petshop.controller.dto.category.cateogoryGroup.CategoryGroupRequestDTO;
import com.topcare.petshop.controller.dto.category.cateogoryGroup.CategoryGroupResponseDTO;
import com.topcare.petshop.service.category.categoryGroup.CategoryGroupServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("topcare/category")
@AllArgsConstructor
public class CategoryGroupController {

    CategoryGroupServiceImpl categoryGroupService;

    @PostMapping
    public ResponseEntity createCategoryGroup(@RequestBody CategoryGroupRequestDTO categoryGroupDTO){

        try {
            return new  ResponseEntity<>(categoryGroupService.createCategoryGroup(categoryGroupDTO), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity findCategoryGroupById(@PathVariable Long id){

        try{
            return new ResponseEntity<>(categoryGroupService.getCategoryGroupById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity findAllCategoryGroup(){
        return new ResponseEntity<>(categoryGroupService.getAllCategoriesGroup(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity editCategoryGroup(@PathVariable Long id, @RequestBody CategoryGroupRequestDTO categoryGroupDTO){
        try{
            return new ResponseEntity<>(categoryGroupService.editCategoryGroup(id, categoryGroupDTO) ,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategoryGroupById(@PathVariable Long id){

       try {
           categoryGroupService.deleteCategoryGroupById(id);
           return new ResponseEntity<>(HttpStatus.OK);
       }catch (Exception e){
           return new ResponseEntity<>(e.getMessage(),
                   HttpStatus.NOT_FOUND);
       }


    }

}
