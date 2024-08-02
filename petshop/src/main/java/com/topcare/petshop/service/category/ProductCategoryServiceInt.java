package com.topcare.petshop.service.category;

import com.topcare.petshop.entity.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductCategoryServiceInt {

    List<ProductCategory> getAllProductCategory(List<String> categories);
    List<ProductCategory> getAllProductCategoryByCategoryGroup(Long id);
    ProductCategory getProductCategoryByTitle(String title) throws Exception;


}
