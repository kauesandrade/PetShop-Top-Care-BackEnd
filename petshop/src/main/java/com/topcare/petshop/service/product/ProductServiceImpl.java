package com.topcare.petshop.service.product;

import com.topcare.petshop.controller.dto.search.SearchResquestDTO;
import com.topcare.petshop.controller.dto.product.request.ProductRequestPostDTO;
import com.topcare.petshop.controller.dto.product.response.ProductResponseDTO;
import com.topcare.petshop.entity.*;
import com.topcare.petshop.repository.ProductRepository;
import com.topcare.petshop.repository.ProductVariantRepository;
import com.topcare.petshop.service.brand.BrandServiceImpl;
import com.topcare.petshop.service.category.ProductCategoryServiceImpl;
import com.topcare.petshop.service.filter.FilterServiceImpl;
import com.topcare.petshop.service.sortBy.SortByServiceImpl;
import com.topcare.petshop.service.search.SearchServiceImpl;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductServiceInt {

    private final ProductRepository repository;
    private final ProductVariantRepository productVariantRepository;
    private final BrandServiceImpl brandService;
    private final ProductCategoryServiceImpl productCategoryService;
    private final FilterServiceImpl filterService;
    private  final SortByServiceImpl orderByService;
    private  final SearchServiceImpl searchService;

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

        Brand brand = brandService.findBrandByName(productPostDTO.brand().getName());

        List<ProductCategory> productCategories =
                productCategoryService.getAllProductCategory(productPostDTO.categories());
        List<ProductSpecification> productSpecifications =
                productPostDTO.specifications().stream().map(ProductSpecification::new).toList();
        List<ProductVariant> productVariants = productPostDTO.variants()
                .stream().map(ProductVariant::new).toList();

        Product product = new Product(productPostDTO, brand, productCategories, productSpecifications, productVariants);
        return repository.save(product);
    }

    @Override
    public ProductResponseDTO editProduct(ProductRequestPostDTO productPutDTO, Long code) {

        ModelMapper modelMapper = new ModelMapper();

        Product product = modelMapper.map(productPutDTO, Product.class);
        product.setCode(code);

        return repository.save(product).toDTO();
    }

    @Override
    public void deleteProductByCode(Long code) throws Exception {
        existProductByCode(code);
        repository.findByCode(code).get().changeEnableProduct();
    }

    @Override
    public Boolean existProductByCode(Long code) throws Exception {
        if(code == null || !repository.existsByCode(code) || !repository.findByCode(code).get().getEnabled()){
            throw new Exception("Produto não encontrado!");
        }
        return true;
    }

    @Override
    public Page<Product> searchProduct(SearchResquestDTO searchResquestDTO) {
        Page<Product> productPage;
        List<Product> productList;

        productList = filterService.filterProducts(searchResquestDTO.productCategoryList());
        productList = searchService.searchProducts(productList, searchResquestDTO.search());
        productPage = orderByService.sortProductsBy(productList, searchResquestDTO);

        return productPage;
    }

    @Override
    public Page<Product> findAllProductByIds(List<Long> productIds, Pageable pageable) {
        return repository.findAllByIdIn(productIds, pageable);
    }
}
