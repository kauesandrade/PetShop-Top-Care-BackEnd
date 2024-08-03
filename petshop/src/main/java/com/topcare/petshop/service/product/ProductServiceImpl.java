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
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductServiceInt {

    private final ProductRepository repository;
    private final ProductVariantRepository productVariantRepository;
    private final BrandServiceImpl brandService;
    private final ProductCategoryServiceImpl productCategoryService;

    @Override
    public ProductResponseDTO findProductByCode(Long code) throws Exception {
       existProductByCode(code);
       return repository.findByCode(code).get().toDTO();
    }

    @Override
    public Product createProduct(ProductRequestPostDTO productPostDTO) throws Exception {

        if(repository.existsByCode(productPostDTO.code())){
            throw new Exception("Esse código já está vinculado a um produto");
        }

        Brand brand = brandService.findBrandByName(productPostDTO.brand());
        List<ProductCategory> productCategories = productCategoryService.findAllProductCategory(productPostDTO.categories());

        List<ProductSpecification> productSpecifications =
                productPostDTO.specifications().stream().map(ProductSpecification::new).toList();


        //Fazer na controler a questão de criar uma variação de produto
        List<ProductVariant> productVariants = productPostDTO.variants().stream().map(ProductVariant::new).toList();

//        List<ProductCategory> productCategories =
//                productCategoryService.getAllProductCategory(productPostDTO.categories());
//        List<ProductSpecification> productSpecifications =
//                productPostDTO.specifications().stream().map(ProductSpecification::new).toList();
//        List<ProductVariant> productVariants = productPostDTO.variants()
//                .stream().map(ProductVariant::new).toList();


        Product product = new Product(productPostDTO, brand, productCategories, productSpecifications, productVariants);
        return repository.save(product);
    }

    @Override
    public ProductResponseDTO editProduct(ProductRequestPostDTO productPutDTO, Long code) {

        ModelMapper modelMapper = new ModelMapper();

        Product product = modelMapper.map(productPutDTO, Product.class);
        product.setCode(code);

        repository.save(product);
        System.out.println(product);

        return repository.save(product).toDTO();
    }

    @Override
    public void deleteProductByCode(Long code) throws Exception {
        existProductByCode(code);
        repository.deleteByCode(code);
    }

    @Override
    public Boolean existProductByCode(Long code) throws Exception {
        if(code == null || !repository.existsByCode(code)){
            throw new Exception("Produto não encontrado!");
        }
        return true;
    }

}
