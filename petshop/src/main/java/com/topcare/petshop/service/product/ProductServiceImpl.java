package com.topcare.petshop.service.product;

import com.topcare.petshop.controller.dto.product.response.card.ProductResponseCardDTO;
import com.topcare.petshop.controller.dto.product.response.searchPage.ProductResponseSearchPageableDTO;
import com.topcare.petshop.controller.dto.search.SearchRequestDTO;
import com.topcare.petshop.controller.dto.product.request.ProductRequestPostDTO;
import com.topcare.petshop.controller.dto.product.response.page.ProductResponsePageDTO;
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
    private final FilterServiceImpl filterService;
    private  final SortByServiceImpl sortByService;
    private  final SearchServiceImpl searchService;

    @Override
    public ProductResponsePageDTO getProductByCode(Long code) throws Exception {
       existProductByCode(code);
       return repository.findByCode(code).get().toPageDTO();
    }


    @Override
    public ProductResponsePageDTO createProduct(ProductRequestPostDTO productPostDTO) throws Exception {

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
        return repository.save(product).toPageDTO();
    }

    @Override
    public ProductResponsePageDTO editProduct(ProductRequestPostDTO productPutDTO, Long code) {

        ModelMapper modelMapper = new ModelMapper();

        Product product = modelMapper.map(productPutDTO, Product.class);
        product.setCode(code);

        return repository.save(product).toPageDTO();
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

    public List<ProductResponseCardDTO> getSimilarProductsByCode(Long code) throws Exception {
        existProductByCode(code);
        Product product = repository.findByCode(code).get();
        List<Product> similarProducts = filterService.filterProducts(product.getCategories().stream().map(ProductCategory::getId).toList());
        similarProducts = checkListOfProductsIsEnable(similarProducts);

        if(similarProducts.size() >= 10){
            similarProducts = similarProducts.stream().filter(product1 -> !product1.getCode().equals(product.getCode())).toList().subList(0, 9);
        }

        return similarProducts.stream().map(Product::toCardDTO).toList();
    }

    @Override
    public List<ProductResponseCardDTO> getProductsByCategories(List<Long> categories) throws Exception {

        List<Product> products = filterService.filterProducts(categories);
        products = checkListOfProductsIsEnable(products);

        if (products.size() >= 10) {
            products = products.subList(0, 9);
        }

        return products.stream().map(Product::toCardDTO).toList();
    }

    @Override
    public Page<ProductResponseSearchPageableDTO> searchProduct(SearchRequestDTO searchRequestDTO, List<Long> productCategories) {
        Page<Product> productPage;
        List<Product> productList;

        productList = filterService.filterProducts(productCategories);
        productList = checkListOfProductsIsEnable(productList);
        productList = searchService.searchProducts(productList, searchRequestDTO.searchValue());
        productPage = sortByService.sortProductsBy(productList, searchRequestDTO);

        return productPage.map(Product::toSearchPageableDTO);
    }

    @Override
    public List<Product> checkListOfProductsIsEnable(List<Product> products) {
        return products.stream().filter(Product::getEnabled).toList();
    }

}
