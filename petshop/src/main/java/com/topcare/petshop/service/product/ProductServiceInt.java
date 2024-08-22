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
/**
 * Interface para os serviços relacionados à entidade {@link Product}.
 * Define métodos para manipulação de produtos, incluindo criação, edição, exclusão e pesquisa.
 */
@Service
public interface ProductServiceInt {

    /**
     * Retorna um produto com base no código fornecido.
     *
     * @param code Código do produto.
     * @return DTO do produto.
     * @throws Exception Se o produto não for encontrado ou não estiver habilitado.
     */
    ProductResponsePageDTO getProductByCode(Long code) throws Exception;

    /**
     * Retorna uma lista de produtos similares ao produto com o código fornecido.
     *
     * @param code Código do produto.
     * @return Lista de DTOs dos produtos similares.
     * @throws Exception Se o produto não for encontrado.
     */
    List<ProductResponseCardDTO> getSimilarProductsByCode(Long code) throws Exception;

    /**
     * Retorna uma lista de produtos com base em uma lista de IDs de categorias fornecidas.
     *
     * @param categories Lista de IDs de categorias.
     * @return Lista de DTOs dos produtos.
     * @throws Exception Se não houver produtos nas categorias fornecidas.
     */
    List<ProductResponseCardDTO> getProductsByCategories(List<Long> categories) throws Exception;

    /**
     * Cria um novo produto com base no DTO fornecido.
     *
     * @param productPostDTO DTO contendo os detalhes do produto.
     * @return DTO do produto criado.
     * @throws Exception Se o código do produto já estiver em uso.
     */
    ProductResponsePageDTO createProduct(ProductRequestPostDTO productPostDTO) throws Exception;

    /**
     * Edita um produto existente com base no código e no DTO fornecidos.
     *
     * @param productPutDTO DTO contendo as novas informações do produto.
     * @param code Código do produto a ser editado.
     * @return DTO do produto editado.
     */
    ProductResponsePageDTO editProduct(ProductRequestPostDTO productPutDTO, Long code);

    /**
     * Exclui um produto com base no código fornecido.
     * Marca o produto como desabilitado em vez de removê-lo fisicamente.
     *
     * @param code Código do produto a ser excluído.
     * @throws Exception Se o produto não for encontrado ou não estiver habilitado.
     */
    void deleteProductByCode(Long code) throws Exception;

    /**
     * Verifica se um produto com o código fornecido existe e está habilitado.
     *
     * @param code Código do produto.
     * @return {@code true} se o produto existir e estiver habilitado, {@code false} caso contrário.
     * @throws Exception Se o produto não for encontrado ou não estiver habilitado.
     */
    Boolean existProductByCode(Long code) throws Exception;

    /**
     * Pesquisa produtos com base em critérios de pesquisa e categorias fornecidas.
     *
     * @param searchRequestDTO DTO contendo os critérios de pesquisa.
     * @param productCategories Lista de IDs de categorias para filtragem.
     * @return Página de DTOs dos produtos encontrados.
     */
    Page<ProductResponseSearchPageableDTO> searchProduct(SearchRequestDTO searchRequestDTO, List<Long> productCategories) throws Exception;

    /**
     * Filtra uma lista de produtos para incluir apenas aqueles que estão habilitados.
     *
     * @param products Lista de produtos.
     * @return Lista de produtos habilitados.
     */
    List<Product> checkListOfProductsIsEnable(List<Product> products);
}

