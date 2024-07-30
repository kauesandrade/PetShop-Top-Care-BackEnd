package com.topcare.petshop.service.product;

import com.topcare.petshop.controller.dto.product.request.ProductRequestPostDTO;
import com.topcare.petshop.controller.dto.product.request.ProductRequestPutDTO;
import com.topcare.petshop.controller.dto.product.response.ProductResponseDTO;
import com.topcare.petshop.entity.*;
import com.topcare.petshop.repository.ProductRepository;
import com.topcare.petshop.repository.ProductVariantRepository;
import com.topcare.petshop.service.brand.BrandServiceImpl;
import com.topcare.petshop.service.category.ProductCategoryServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductServiceInt {

    private final ProductRepository repository;
    private final ProductVariantRepository productVariantRepository;
    private final BrandServiceImpl brandService;
    private final ProductCategoryServiceImpl productCategoryService;

    @Override
    public ProductResponseDTO findProductByCode(Long code) {
        ProductResponseDTO productResponseDTO = repository.findByCode(code).get().toDTO();
        return productResponseDTO;
    }

    @Override
    public Product createProduct(ProductRequestPostDTO productPostDTO) {
        Brand brand = brandService.findBrandByName(productPostDTO.brand());

        List<ProductCategory> productCategories = productCategoryService.findAllProductCategory(productPostDTO.categories());

        List<ProductSpecification> productSpecifications =
                productPostDTO.specifications().stream().map(ProductSpecification::new).toList();

        List<ProductVariant> productVariants = productPostDTO.variants().stream().map(ProductVariant::new).toList();

        Product product = new Product(productPostDTO, brand, productCategories, productSpecifications, productVariants);

        return repository.save(product);
    }

    @Override
    public ProductResponseDTO editProduct(ProductRequestPutDTO productPutDTO) {
        return null;
    }

    @Override
    public boolean deleteProductByCode(Long code) {
        if (!repository.existsByCode(code)) {
            return false;
        }
        repository.deleteByCode(code);
        return true;
    }

}
