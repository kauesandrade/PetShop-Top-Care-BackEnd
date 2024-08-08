package com.topcare.petshop.service.filter;

import com.topcare.petshop.entity.Product;
import com.topcare.petshop.entity.ProductCategory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FilterServiceImpl implements FilterServiceInt{

    @Override
    public List<Product> filterProducts(List<Product> productList, List<ProductCategory> productCategoryList) {
        return null;
    }
}
