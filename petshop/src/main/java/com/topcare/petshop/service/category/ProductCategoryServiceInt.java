package com.topcare.petshop.service.category;

import com.topcare.petshop.entity.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductCategoryServiceInt {

    List<ProductCategory> getAllProductCategory(List<ProductCategory> categories) throws Exception;
    List<ProductCategory> getAllProductCategoryByCategoryGroup(Long id);
    ProductCategory getProductCategoryByTitle(String title) throws Exception;
    Boolean existProductCategoryById(Long id) throws Exception;
    ProductCategory getProductCategoryById(Long id) throws Exception;
    void deleteProductCategoryById(Long id) throws Exception;

}
