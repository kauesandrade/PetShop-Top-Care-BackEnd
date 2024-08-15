package com.topcare.petshop.service.category;

import com.topcare.petshop.entity.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductCategoryServiceInt {

    List<ProductCategory> findAllProductCategory(List<String> categories);

}
