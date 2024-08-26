package com.topcare.petshop.service.product;

import com.topcare.petshop.controller.dto.category.ProductCategoryResponseDTO;
import com.topcare.petshop.controller.dto.category.cateogoryGroup.CategoryGroupFiltersResponseDTO;
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
import com.topcare.petshop.service.category.categoryGroup.CategoryGroupServiceImpl;
import com.topcare.petshop.service.filter.FilterServiceImpl;
import com.topcare.petshop.service.sortBy.SortByServiceImpl;
import com.topcare.petshop.service.search.SearchServiceImpl;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Implementa os serviços relacionados à entidade {@link Product}.
 * Fornece métodos para manipulação de produtos, incluindo criação, edição, exclusão e pesquisa.
 */
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductServiceInt {

    private final ProductRepository repository;
    private final BrandServiceImpl brandService;
    private final ProductCategoryServiceImpl productCategoryService;
    private final FilterServiceImpl filterService;
    private final SortByServiceImpl sortByService;
    private final SearchServiceImpl searchService;

    /**
     * Retorna um produto com base no código fornecido.
     *
     * @param code Código do produto.
     * @return DTO do produto.
     * @throws Exception Se o produto não for encontrado ou não estiver habilitado.
     */
    @Override
    public ProductResponsePageDTO getProductByCode(Long code) throws Exception {
        existProductByCode(code);
        return repository.findByCode(code).get().toPageDTO();
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    /**
     * Cria um novo produto com base no DTO fornecido.
     *
     * @param productPostDTO DTO contendo os detalhes do produto.
     * @return DTO do produto criado.
     * @throws Exception Se o código do produto já estiver em uso.
     */
    @Override
    public ProductResponsePageDTO createProduct(ProductRequestPostDTO productPostDTO) throws Exception {
        if (repository.existsByCode(productPostDTO.code())) {
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

    /**
     * Edita um produto existente com base no código e no DTO fornecidos.
     *
     * @param productPutDTO DTO contendo as novas informações do produto.
     * @param code Código do produto a ser editado.
     * @return DTO do produto editado.
     */
    @Override
    public ProductResponsePageDTO editProduct(ProductRequestPostDTO productPutDTO, Long code) {
        ModelMapper modelMapper = new ModelMapper();
        Product product = modelMapper.map(productPutDTO, Product.class);
        product.setCode(code);
        return repository.save(product).toPageDTO();
    }

    /**
     * Exclui um produto com base no código fornecido.
     * Marca o produto como desabilitado em vez de removê-lo fisicamente.
     *
     * @param code Código do produto a ser excluído.
     * @throws Exception Se o produto não for encontrado ou não estiver habilitado.
     */
    @Override
    public void deleteProductByCode(Long code) throws Exception {
        existProductByCode(code);
        repository.findByCode(code).get().changeEnableProduct();
    }

    /**
     * Verifica se um produto com o código fornecido existe e está habilitado.
     *
     * @param code Código do produto.
     * @return {@code true} se o produto existir e estiver habilitado, {@code false} caso contrário.
     * @throws Exception Se o produto não for encontrado ou não estiver habilitado.
     */
    @Override
    public Boolean existProductByCode(Long code) throws Exception {
        if (code == null || !repository.existsByCode(code) || !repository.findByCode(code).get().getEnabled()) {
            throw new Exception("Produto não encontrado!");
        }
        return true;
    }

    /**
     * Retorna uma lista de produtos similares ao produto com o código fornecido.
     *
     * @param code Código do produto.
     * @return Lista de DTOs dos produtos similares.
     * @throws Exception Se o produto não for encontrado.
     */
    public List<ProductResponseCardDTO> getSimilarProductsByCode(Long code) throws Exception {
        existProductByCode(code);
        Product product = repository.findByCode(code).get();
        List<Product> similarProducts = filterService.filterProducts(product.getCategories().stream().map(ProductCategory::getId).toList());
        similarProducts = checkListOfProductsIsEnable(similarProducts);

        if (similarProducts.size() >= 10) {
            similarProducts = similarProducts.stream().filter(product1 -> !product1.getCode().equals(product.getCode())).toList().subList(0, 9);
        }

        return similarProducts.stream().map(Product::toCardDTO).toList();
    }

    /**
     * Retorna uma lista de produtos com base em uma lista de IDs de categorias fornecidas.
     *
     * @param categories Lista de IDs de categorias.
     * @return Lista de DTOs dos produtos.
     * @throws Exception Se não houver produtos nas categorias fornecidas.
     */
    @Override
    public List<ProductResponseCardDTO> getProductsByCategories(List<Long> categories) throws Exception {
        List<Product> products = filterService.filterProducts(categories);
        products = checkListOfProductsIsEnable(products);

        if (products.size() >= 10) {
            products = products.subList(0, 9);
        }

        return products.stream().map(Product::toCardDTO).toList();
    }

    /**
     * Pesquisa produtos com base em critérios de pesquisa e categorias fornecidas.
     *
     * @param searchRequestDTO DTO contendo os critérios de pesquisa.
     * @param productCategories Lista de IDs de categorias para filtragem.
     * @return Página de DTOs dos produtos encontrados.
     */
    @Override
    public Page<ProductResponseCardDTO> searchProduct(SearchRequestDTO searchRequestDTO, List<Long> productCategories) {
        Page<Product> productPage;
        List<Product> productList;

        productList = filterService.filterProducts(productCategories);
        productList = checkListOfProductsIsEnable(productList);
        productList = searchService.searchProducts(productList, searchRequestDTO.searchValue());
        productPage = sortByService.sortProductsBy(productList, searchRequestDTO);

        return productPage.map(Product::toCardDTO);
    }

    /**
     * Filtra uma lista de produtos para incluir apenas aqueles que estão habilitados.
     *
     * @param products Lista de produtos.
     * @return Lista de produtos habilitados.
     */
    @Override
    public List<Product> checkListOfProductsIsEnable(List<Product> products) {
        return products.stream().filter(Product::getEnabled).toList();
    }
}
