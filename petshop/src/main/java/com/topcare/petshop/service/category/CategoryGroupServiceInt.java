package com.topcare.petshop.service.category;

import com.topcare.petshop.controller.dto.category.CategoryGroupRequestPostDTO;
import com.topcare.petshop.controller.dto.category.CategoryGroupResponseDTO;
import com.topcare.petshop.controller.dto.category.CategoryResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryGroupServiceInt {

    CategoryGroupResponseDTO createCategoryGroup(CategoryGroupRequestPostDTO categoryGroupDTO);

    List<CategoryGroupResponseDTO> getAllCategoriesGroup();

    CategoryGroupResponseDTO findCategoryGroupByTitle(String title);

    Boolean deleteCategoryGroupByTitle(String title);

}
