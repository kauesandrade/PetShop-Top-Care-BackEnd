package com.topcare.petshop.service.category.categoryGroup;

import com.topcare.petshop.controller.dto.category.cateogoryGroup.CategoryGroupFiltersResponseDTO;
import com.topcare.petshop.controller.dto.category.cateogoryGroup.CategoryGroupRequestDTO;
import com.topcare.petshop.controller.dto.category.cateogoryGroup.CategoryGroupResponseDTO;
import com.topcare.petshop.entity.Product;
import com.topcare.petshop.entity.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryGroupServiceInt {

    CategoryGroupResponseDTO getCategoryGroupById(Long id) throws Exception;
    List<CategoryGroupResponseDTO> getAllCategoriesGroup();
    CategoryGroupResponseDTO createCategoryGroup(CategoryGroupRequestDTO categoryGroupDTO) throws Exception;
    CategoryGroupResponseDTO editCategoryGroup(Long id, CategoryGroupRequestDTO categoryGroupDTO) throws Exception;
    void deleteCategoryGroupById(Long id) throws Exception;
    Boolean existCategoryGroupById(Long id) throws Exception;
    List<CategoryGroupFiltersResponseDTO> getFilters(String searchValue);
}
