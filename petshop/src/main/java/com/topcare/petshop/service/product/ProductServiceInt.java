package com.topcare.petshop.service.product;

import com.topcare.petshop.controller.dto.product.request.ProductRequestPostDTO;
import com.topcare.petshop.controller.dto.product.response.ProductResponseDTO;
import com.topcare.petshop.entity.Product;
import com.topcare.petshop.entity.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public interface ProductServiceInt {

    ProductResponseDTO getProductByCode(Long code) throws Exception;
    Product createProduct(ProductRequestPostDTO productPostDTO) throws Exception;
    ProductResponseDTO editProduct(ProductRequestPostDTO productPutDTO, Long code);
    void deleteProductByCode(Long code) throws Exception;
    Boolean existProductByCode(Long code) throws Exception;
    Page<Product> searchProduct(String seachValue,
                                String orderBy,
                                List<ProductCategory> productCategoryList);



}
