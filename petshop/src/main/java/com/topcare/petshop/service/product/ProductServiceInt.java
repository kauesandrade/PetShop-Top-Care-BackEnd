package com.topcare.petshop.service.product;

import com.topcare.petshop.controller.dto.product.request.ProductRequestPutDTO;
import com.topcare.petshop.controller.dto.product.request.ProductRequestPostDTO;
import com.topcare.petshop.controller.dto.product.response.ProductResponseDTO;
import com.topcare.petshop.entity.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductServiceInt {

    ProductResponseDTO findProductByCode(Long code) throws Exception;

    Product createProduct(ProductRequestPostDTO productPostDTO) throws Exception;

    ProductResponseDTO editProduct(ProductRequestPostDTO productPutDTO, Long code);

    void deleteProductByCode(Long code) throws Exception;

    Boolean existProductByCode(Long code) throws Exception;

//    ProductResponseDTO findProductByCode(Long code) throws Exception;
//    Product createProduct(ProductRequestPostDTO productPostDTO) throws Exception;
//    ProductResponseDTO editProduct(ProductRequestPutDTO productPutDTO);
//    void deleteProductByCode(Long code) throws Exception;


}
