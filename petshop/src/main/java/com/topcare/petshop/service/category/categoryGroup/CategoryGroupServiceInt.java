package com.topcare.petshop.service.category.categoryGroup;

import com.topcare.petshop.controller.dto.category.cateogoryGroup.CategoryGroupRequestDTO;
import com.topcare.petshop.controller.dto.category.cateogoryGroup.CategoryGroupResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryGroupServiceInt {

    CategoryGroupResponseDTO createCategoryGroup(CategoryGroupRequestDTO categoryGroupDTO) throws Exception;
    CategoryGroupResponseDTO getCategoryGroupByTitle(String title) throws Exception;
    List<CategoryGroupResponseDTO> getAllCategoriesGroup();
    CategoryGroupResponseDTO editCategoryGroup(Long id, CategoryGroupRequestDTO categoryGroupDTO) throws Exception;
    void deleteCategoryGroupByTitle(String title) throws Exception;


}
