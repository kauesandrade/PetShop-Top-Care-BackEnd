package com.topcare.petshop.service.product;

import com.topcare.petshop.controller.dto.SearchResquestDTO;
import com.topcare.petshop.controller.dto.product.request.ProductRequestPostDTO;
import com.topcare.petshop.controller.dto.product.response.ProductResponseDTO;
import com.topcare.petshop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductServiceInt {

    ProductResponseDTO findProductByCode(Long code) throws Exception;
    Product createProduct(ProductRequestPostDTO productPostDTO) throws Exception;
    ProductResponseDTO editProduct(ProductRequestPostDTO productPutDTO, Long code);
    void deleteProductByCode(Long code) throws Exception;
    Boolean existProductByCode(Long code) throws Exception;
    Page<Product> searchProduct(SearchResquestDTO searchResquestDTO) throws Exception;

    Page<Product> findAllProductByIds(List<Long> productIds, Pageable pageable);

}
