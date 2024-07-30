package com.topcare.petshop.controller;


import com.topcare.petshop.controller.dto.category.CategoryGroupRequestPostDTO;
import com.topcare.petshop.controller.dto.category.CategoryGroupResponseDTO;
import com.topcare.petshop.controller.dto.category.CategoryResponseDTO;
import com.topcare.petshop.service.category.CategoryGroupServiceImpl;
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
    public ResponseEntity<CategoryGroupResponseDTO> createCategoryGroup(@RequestBody CategoryGroupRequestPostDTO categoryGroupDTO){
        CategoryGroupResponseDTO categoryGroup = categoryGroupService.createCategoryGroup(categoryGroupDTO);

        if(categoryGroup == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>( categoryGroup, HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public ResponseEntity<CategoryGroupResponseDTO> findCategoryGroupByTitle(@PathVariable String title){

        CategoryGroupResponseDTO categoryGroup = categoryGroupService.findCategoryGroupByTitle(title);

        if(categoryGroup == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(categoryGroup, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CategoryGroupResponseDTO>> findAllCategoryGroup(){
        List<CategoryGroupResponseDTO> allCategoriesGroup = categoryGroupService.getAllCategoriesGroup();

        if(allCategoriesGroup.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(allCategoriesGroup, HttpStatus.OK);
    }

    @DeleteMapping("/{title}")
    public ResponseEntity<Boolean> deleteCategoryGroupByTitle(@PathVariable String title){

        Boolean delete = categoryGroupService.deleteCategoryGroupByTitle(title);

        if(delete == false){
            return new ResponseEntity<>(delete, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(delete,HttpStatus.OK);
    }

}
