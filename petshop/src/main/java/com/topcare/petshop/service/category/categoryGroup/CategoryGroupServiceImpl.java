package com.topcare.petshop.service.category.categoryGroup;

import com.topcare.petshop.controller.dto.category.cateogoryGroup.CategoryGroupRequestDTO;
import com.topcare.petshop.controller.dto.category.cateogoryGroup.CategoryGroupResponseDTO;
import com.topcare.petshop.entity.CategoryGroup;
import com.topcare.petshop.entity.ProductCategory;
import com.topcare.petshop.repository.CategoryGroupRepository;
import com.topcare.petshop.service.category.ProductCategoryServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoryGroupServiceImpl implements CategoryGroupServiceInt {

    private final CategoryGroupRepository repository;
    private final ProductCategoryServiceImpl categoryService;

    @Override
    public CategoryGroupResponseDTO createCategoryGroup(CategoryGroupRequestDTO categoryGroupDTO) throws Exception {

        try {
            List<ProductCategory> productCategories = categoryGroupDTO
                    .categories().stream().map(ProductCategory::new).toList();

            CategoryGroup categoryGroup = new CategoryGroup(categoryGroupDTO, productCategories);

            return repository.save(categoryGroup).toDTO();
        }catch (Exception e){
            throw new Exception("Não foi possível cria o grupo de categoria!");
        }
    }

    @Override
    public CategoryGroupResponseDTO getCategoryGroupByTitle(String title) throws Exception {
        if(repository.findCategoryGroupByTitle(title).isEmpty()){
            throw new Exception("Grupo de categoria não encontrado!");
        }
        return repository.findCategoryGroupByTitle(title).get().toDTO();

    }

    @Override
    public List<CategoryGroupResponseDTO> getAllCategoriesGroup() {
        return repository.findAll().stream().map(categoryGroup
                -> categoryGroup.toDTO()).toList();
    }

    @Override
    public CategoryGroupResponseDTO editCategoryGroup(Long id, CategoryGroupRequestDTO categoryGroupDTO) throws Exception {

        CategoryGroup categoryGroup = repository.findById(id).get();

        List<ProductCategory> productCategories = new ArrayList<>();

        for(String newCategory : categoryGroupDTO.categories()){
            for (ProductCategory category : categoryGroup.getCategories()){
                if (newCategory != category.getTitle()){
                    productCategories.add(new ProductCategory(newCategory));
                }else {
                    productCategories.add(category);
                }
            }
        }

        categoryGroup.edit(categoryGroupDTO, productCategories);

        return repository.save(categoryGroup).toDTO();
    }

    @Override
    public void deleteCategoryGroupByTitle(String title) throws Exception {
        if(!repository.existsCategoryGroupByTitle(title)){
            throw new Exception("Grupo de categoria não encontrado!");
        }

        for(ProductCategory productCategory : categoryService.getAllProductCategoryByCategoryGroup(repository.findCategoryGroupByTitle(title).get().getId())){
            repository.deleteByCategoryId(productCategory.getId());
        }
        repository.deleteCategoryGroupByTitle(title);
    }


}
