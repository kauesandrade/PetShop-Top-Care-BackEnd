package com.topcare.petshop.service.product;

import com.topcare.petshop.controller.dto.product.request.ProductRequestPutDTO;
import com.topcare.petshop.controller.dto.product.request.ProductRequestPostDTO;
import com.topcare.petshop.controller.dto.product.response.ProductResponseDTO;
import com.topcare.petshop.entity.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductServiceInt {

    ProductResponseDTO findProductByCode(Long code);

    Product createProduct(ProductRequestPostDTO productPostDTO);

    ProductResponseDTO editProduct(ProductRequestPostDTO productPutDTO, Long code);

    boolean deleteProductByCode(Long code);

}
