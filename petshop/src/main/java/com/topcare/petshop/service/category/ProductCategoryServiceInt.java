package com.topcare.petshop.service.category;

import com.topcare.petshop.entity.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Interface para os serviços relacionados à entidade {@link ProductCategory}.
 * Define os métodos para manipulação de categorias de produtos, incluindo criação, leitura, exclusão e verificação.
 */
@Service
public interface ProductCategoryServiceInt {

    /**
     * Retorna uma lista de categorias de produtos com base em uma lista fornecida de categorias.
     *
     * @param categories Lista de categorias de produtos.
     * @return Lista de categorias de produtos encontradas.
     * @throws Exception Se alguma das categorias de produtos não for encontrada.
     */
    List<ProductCategory> getAllProductCategory(List<ProductCategory> categories) throws Exception;

    /**
     * Retorna todas as categorias de produtos associadas a um grupo de categorias específico.
     *
     * @param id ID do grupo de categorias.
     * @return Lista de categorias de produtos associadas ao grupo.
     */
    List<ProductCategory> getAllProductCategoryByCategoryGroup(Long id);

    /**
     * Verifica se uma categoria de produto com o ID fornecido existe.
     *
     * @param id ID da categoria de produto.
     * @return True se a categoria de produto existir, caso contrário, lança uma exceção.
     * @throws Exception Se a categoria de produto não for encontrada.
     */
    Boolean existProductCategoryById(Long id) throws Exception;

    /**
     * Retorna uma categoria de produto com base no ID fornecido.
     *
     * @param id ID da categoria de produto.
     * @return Categoria de produto encontrada.
     * @throws Exception Se a categoria de produto não for encontrada.
     */
    ProductCategory getProductCategoryById(Long id) throws Exception;

    /**
     * Exclui uma categoria de produto com base no ID fornecido.
     * Também exclui qualquer relação associada à categoria de produto.
     *
     * @param id ID da categoria de produto a ser excluída.
     * @throws Exception Se a categoria de produto não for encontrada ou ocorrer um erro.
     */
    void deleteProductCategoryById(Long id) throws Exception;
}
