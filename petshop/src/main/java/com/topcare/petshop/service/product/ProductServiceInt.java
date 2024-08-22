package com.topcare.petshop.service.product;

import com.topcare.petshop.controller.dto.product.response.card.ProductResponseCardDTO;
import com.topcare.petshop.controller.dto.product.response.searchPage.ProductResponseSearchPageableDTO;
import com.topcare.petshop.controller.dto.search.SearchRequestDTO;
import com.topcare.petshop.controller.dto.product.request.ProductRequestPostDTO;
import com.topcare.petshop.controller.dto.product.response.page.ProductResponsePageDTO;
import com.topcare.petshop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductServiceInt {

    ProductResponsePageDTO getProductByCode(Long code) throws Exception;
    List<ProductResponseCardDTO> getSimilarProductsByCode(Long code) throws Exception;
    List<ProductResponseCardDTO> getProductsByCategories(List<Long> categories) throws Exception;
    ProductResponsePageDTO createProduct(ProductRequestPostDTO productPostDTO) throws Exception;
    ProductResponsePageDTO editProduct(ProductRequestPostDTO productPutDTO, Long code);
    void deleteProductByCode(Long code) throws Exception;
    Boolean existProductByCode(Long code) throws Exception;
    Page<ProductResponseSearchPageableDTO> searchProduct(SearchRequestDTO searchRequestDTO, List<Long> productCategories) throws Exception;

    List<Product> checkListOfProductsIsEnable(List<Product> products);

//    Page<ProductResponsePageDTO> findAllProductByIds(List<Long> productIds, Pageable pageable);


}

