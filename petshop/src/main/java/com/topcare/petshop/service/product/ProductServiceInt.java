package com.topcare.petshop.service.product;

import com.topcare.petshop.controller.dto.product.request.ProductRequestPutDTO;
import com.topcare.petshop.controller.dto.product.response.ProductResponseGetDTO;
import com.topcare.petshop.controller.dto.product.request.ProductRequestPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface ProductServiceInt {

    ProductResponseGetDTO findProductByCode(Long code);

    void createProduct(ProductRequestPostDTO productPostDTO);

    ProductResponseGetDTO editProduct(ProductRequestPutDTO productPutDTO);

    boolean deletProductByCode(Long code);

}
