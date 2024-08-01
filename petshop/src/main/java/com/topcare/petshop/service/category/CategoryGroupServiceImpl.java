package com.topcare.petshop.service.category;

import com.topcare.petshop.controller.dto.category.CategoryGroupRequestPostDTO;
import com.topcare.petshop.controller.dto.category.CategoryGroupResponseDTO;
import com.topcare.petshop.entity.CategoryGroup;
import com.topcare.petshop.entity.ProductCategory;
import com.topcare.petshop.repository.CategoryGroupRepository;
import com.topcare.petshop.service.product.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryGroupServiceImpl implements CategoryGroupServiceInt {

    private final CategoryGroupRepository repository;
    private final ProductCategoryServiceImpl categoryService;
    private final ProductServiceImpl productService;

    @Override
    public CategoryGroupResponseDTO createCategoryGroup(CategoryGroupRequestPostDTO categoryGroupDTO) {

        List<ProductCategory> productCategories = categoryGroupDTO
                .categories().stream().map(ProductCategory::new).toList();

        CategoryGroup categoryGroup = new CategoryGroup(categoryGroupDTO, productCategories);

        return repository.save(categoryGroup).toDTO();
    }

    @Override
    public List<CategoryGroupResponseDTO> getAllCategoriesGroup() {
        return repository.findAll().stream().map(categoryGroup
                -> categoryGroup.toDTO()).toList();
    }

    @Override
    public CategoryGroupResponseDTO findCategoryGroupByTitle(String title) {
        if(repository.findCategoryGroupByTitle(title).isEmpty()){
            return null;
        }
        return repository.findCategoryGroupByTitle(title).get().toDTO();

    }

    @Override
    public Boolean deleteCategoryGroupByTitle(String title) {
        if(!repository.existsCategoryGroupByTitle(title)){
            return false;
        }


        for(ProductCategory productCategory : categoryService.findAllProductCategoryByCategoryGroup(repository.findCategoryGroupByTitle(title).get().getId())){
            repository.deleteByCategoryId(productCategory.getId());
        }

        repository.deleteCategoryGroupByTitle(title);
        return true;
    }
}
