package com.topcare.petshop.service.product;

import com.topcare.petshop.controller.dto.product.request.ProductRequestPostDTO;
import com.topcare.petshop.controller.dto.product.request.ProductRequestPutDTO;
import com.topcare.petshop.controller.dto.product.request.ProductVariantRequestPostDTO;
import com.topcare.petshop.controller.dto.product.response.ProductResponseGetDTO;
import com.topcare.petshop.entity.*;
import com.topcare.petshop.repository.ProductRepository;
import com.topcare.petshop.repository.ProductVariantRepository;
import com.topcare.petshop.service.brand.BrandServiceImpl;
import com.topcare.petshop.service.category.ProductCategoryServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductServiceInt {

    private final ProductRepository repository;
    private final ProductVariantRepository productVariantRepository;
    private final BrandServiceImpl brandService;
    private final ProductCategoryServiceImpl productCategoryService;

    @Override
    public ProductResponseGetDTO findProductByCode(Long code) {
        ProductResponseGetDTO productResponseDTO = findProductByCode(code);
        return productResponseDTO;
    }

    @Override
    public void createProduct(ProductRequestPostDTO productPostDTO) {
        Brand brand = brandService.findBrandByName(productPostDTO.brand());

        List<ProductCategory> productCategories = productCategoryService.findAllProductCategory(productPostDTO.categories());

        List<ProductSpecification> productSpecifications =
                productPostDTO.specifications().stream().map(ProductSpecification::new).toList();

        Product product = new Product(productPostDTO, brand, productCategories, productSpecifications);

        Product product1 = repository.save(product);

        for(ProductVariantRequestPostDTO variantPostDTO : productPostDTO.variants() ) {
            ProductVariant productVariant =
                    new ProductVariant(variantPostDTO, product1);
            productVariantRepository.save(productVariant);
        }

    }

    @Override
    public ProductResponseGetDTO editProduct(ProductRequestPutDTO productPutDTO) {
        return null;
    }

    @Override
    public boolean deletProductByCode(Long code) {
        return false;
    }
}
