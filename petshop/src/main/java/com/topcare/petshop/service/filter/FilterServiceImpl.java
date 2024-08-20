package com.topcare.petshop.service.filter;

import com.topcare.petshop.entity.Product;
import com.topcare.petshop.entity.ProductCategory;
import com.topcare.petshop.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class FilterServiceImpl implements FilterServiceInt{

    private final ProductRepository productRepository;

    @Override
    public List<Product> filterProducts(List<Long> productCategoryList) {

        if(productCategoryList.isEmpty()) {
            return productRepository.findAll().stream().toList();
        }
        return findAllByCategoryIds(productCategoryList);
    }

    private List<Product> findAllByCategoryIds(List<Long> productCategoryList) {

        HashMap<Long, Product> productList = new HashMap<>();
        for(Long idProduct : productRepository.findAllByCategoryIds(productCategoryList, productCategoryList.size())){
            productList.put(idProduct, productRepository.findById(idProduct).get());
        }
        return productList.values().stream().toList();
    }
}
