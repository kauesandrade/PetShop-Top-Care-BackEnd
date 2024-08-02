package com.topcare.petshop.service.category;

import com.topcare.petshop.entity.ProductCategory;
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
    public List<ProductCategory> getAllProductCategory(List<String> categories) {
        List<ProductCategory> productCategories = new ArrayList<>();

        for(String title : categories){
            productCategories.add(repository.findProductCategorieByTitle(title).get());
        }

        return productCategories;
    }

    @Override
    public List<ProductCategory> getAllProductCategoryByCategoryGroup(Long id) {
        return repository.findAllByCategory_group_id(id);
    }

    @Override
    public ProductCategory getProductCategoryByTitle(String title) throws Exception {

        if(repository.findProductCategorieByTitle(title).isEmpty()){
            throw new Exception("Categoria não encontrada");
        }
        return repository.findProductCategorieByTitle(title).get();
    }


}
