package com.topcare.petshop.service.category;

import com.topcare.petshop.entity.ProductCategory;
import com.topcare.petshop.repository.CategoryGroupRepository;
import com.topcare.petshop.repository.ProductCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Implementa os serviços relacionados à entidade {@link ProductCategory}.
 * Fornece métodos para manipulação de categorias de produtos, incluindo criação, leitura, exclusão e verificação.
 */
@Service
@AllArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryServiceInt {

    private final ProductCategoryRepository repository;

    /**
     * Retorna uma categoria de produto com base no ID fornecido.
     *
     * @param id ID da categoria de produto.
     * @return Categoria de produto encontrada.
     * @throws Exception Se a categoria de produto não for encontrada.
     */
    @Override
    public ProductCategory getProductCategoryById(Long id) throws Exception {
        existProductCategoryById(id);
        return repository.findById(id).get();
    }

    /**
     * Exclui uma categoria de produto com base no ID fornecido.
     * Também exclui qualquer relação associada à categoria de produto.
     *
     * @param id ID da categoria de produto a ser excluída.
     * @throws Exception Se a categoria de produto não for encontrada ou ocorrer um erro.
     */
    @Override
    public void deleteProductCategoryById(Long id) throws Exception {
        if (existProductCategoryById(id)) {
            repository.deleteRelationProductByCategoryId(id);
            repository.deleteById(id);
        }
    }

    /**
     * Retorna uma lista de categorias de produtos com base em uma lista fornecida de categorias.
     *
     * @param categories Lista de categorias de produtos.
     * @return Lista de categorias de produtos encontradas.
     * @throws Exception Se alguma das categorias de produtos não for encontrada.
     */
    @Override
    public List<ProductCategory> getAllProductCategory(List<Long> categories) throws Exception {
        List<ProductCategory> productCategories = new ArrayList<>();

        for (Long productCategory : categories) {
            if (!existProductCategoryById(productCategory)) {
                throw new Exception("A categoria não foi encontrada!");
            }
            productCategories.add(repository.findById(productCategory).get());
        }

        return productCategories;
    }

    /**
     * Retorna todas as categorias de produtos associadas a um grupo de categorias específico.
     *
     * @param id ID do grupo de categorias.
     * @return Lista de categorias de produtos associadas ao grupo.
     */
    @Override
    public List<ProductCategory> getAllProductCategoryByCategoryGroup(Long id) {
        return repository.findAllByCategoryGroup_Id(id);
    }

    /**
     * Verifica se uma categoria de produto com o ID fornecido existe.
     *
     * @param id ID da categoria de produto.
     * @return True se a categoria de produto existir, caso contrário, lança uma exceção.
     * @throws Exception Se a categoria de produto não for encontrada.
     */
    @Override
    public Boolean existProductCategoryById(Long id) throws Exception {
        if (id == null || !repository.existsById(id)) {
            throw new Exception("A categoria não foi encontrada!");
        }
        return true;
    }
}
