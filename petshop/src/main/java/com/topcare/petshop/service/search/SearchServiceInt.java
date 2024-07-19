package com.topcare.petshop.service.search;

import com.topcare.petshop.entity.Product;
import com.topcare.petshop.entity.ProductVariant;
import org.hibernate.query.Page;
import org.springframework.stereotype.Service;

@Service
public interface SearchServiceInt {

    Page<ProductVariant> searchProductsByName (String name);
    

    Page<com.topcare.petshop.entity.Service> searchServicesByName(String name);

}
