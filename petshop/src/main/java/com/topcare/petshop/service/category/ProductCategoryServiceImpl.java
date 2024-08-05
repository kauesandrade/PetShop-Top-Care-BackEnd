package com.topcare.petshop.service.category;

import com.topcare.petshop.entity.ProductCategory;
import com.topcare.petshop.repository.CategoryGroupRepository;
import com.topcare.petshop.repository.ProductCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryServiceInt {

    private final ProductCategoryRepository repository;

    @Override
    public ProductCategory getProductCategoryById(Long id) throws Exception {
        existProductCategoryById(id);
        return repository.findById(id).get();
    }

    @Override
    public void deleteProductCategoryById(Long id) throws Exception {
        if (existProductCategoryById(id)) {
            repository.deleteRelationProductByCategoryId(id);
            repository.deleteById(id);
        }
    }

    @Override
    public List<ProductCategory> getAllProductCategory(List<String> categories) {
        List<ProductCategory> productCategories = new ArrayList<>();

        for(String title : categories){
            productCategories.add(repository.findProductCategorieByTitle(title).get());
        }

        return productCategories;
    }

    @Override
    public ProductCategory getProductCategoryByTitle(String title) throws Exception {

        if(repository.findProductCategorieByTitle(title).isEmpty()){
            throw new Exception("Categoria não encontrada!");
        }
        return repository.findProductCategorieByTitle(title).get();
    }

    @Override
    public List<ProductCategory> getAllProductCategoryByCategoryGroup(Long id) {
        return repository.findAllByCategoryGroup_Id(id);
    }

    @Override
    public Boolean existProductCategoryById(Long id) {
        if(id == null|| !repository.existsById(id)){
            return false;
        }
        return true;
    }


}
