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
    public List<ProductCategory> findAllProductCategory(List<String> categories) {
        List<ProductCategory> productCategories = new ArrayList<>();

        for(String title : categories){
            productCategories.add(repository.findProductCategorieByTitle(title).get());
        }

        return productCategories;
    }

    @Override
    public List<ProductCategory> findAllProductCategoryByCategoryGroup(Long id) {
        return repository.findAllByCategory_group_id(id);
    }


}
