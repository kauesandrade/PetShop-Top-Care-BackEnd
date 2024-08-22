package com.topcare.petshop.service.category.categoryGroup;

import com.topcare.petshop.controller.dto.category.cateogoryGroup.CategoryGroupRequestDTO;
import com.topcare.petshop.controller.dto.category.cateogoryGroup.CategoryGroupResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Interface para os serviços relacionados à entidade {@link CategoryGroup}.
 * Define os métodos para manipulação de grupos de categorias, incluindo criação, leitura, atualização e exclusão.
 */
@Service
public interface CategoryGroupServiceInt {

    /**
     * Retorna um DTO do grupo de categorias com o ID fornecido.
     *
     * @param id ID do grupo de categorias.
     * @return DTO do grupo de categorias.
     * @throws Exception Se o grupo de categorias não for encontrado.
     */
    CategoryGroupResponseDTO getCategoryGroupById(Long id) throws Exception;

    /**
     * Retorna uma lista de todos os grupos de categorias convertidos para DTOs.
     *
     * @return Lista de DTOs dos grupos de categorias.
     */
    List<CategoryGroupResponseDTO> getAllCategoriesGroup();

    /**
     * Cria um novo grupo de categorias com base no DTO fornecido.
     *
     * @param categoryGroupDTO DTO do grupo de categorias a ser criado.
     * @return DTO do grupo de categorias criado.
     * @throws Exception Se ocorrer um erro durante a criação do grupo de categorias.
     */
    CategoryGroupResponseDTO createCategoryGroup(CategoryGroupRequestDTO categoryGroupDTO) throws Exception;

    /**
     * Edita um grupo de categorias existente com base no ID e no DTO fornecidos.
     *
     * @param id ID do grupo de categorias a ser editado.
     * @param categoryGroupDTO DTO com as novas informações.
     * @return DTO do grupo de categorias editado.
     * @throws Exception Se o grupo de categorias não for encontrado ou ocorrer um erro.
     */
    CategoryGroupResponseDTO editCategoryGroup(Long id, CategoryGroupRequestDTO categoryGroupDTO) throws Exception;

    /**
     * Exclui um grupo de categorias pelo ID.
     * Também exclui todas as categorias associadas ao grupo.
     *
     * @param id ID do grupo de categorias a ser excluído.
     * @throws Exception Se o grupo de categorias não for encontrado ou ocorrer um erro.
     */
    void deleteCategoryGroupById(Long id) throws Exception;

    /**
     * Verifica se um grupo de categorias com o ID fornecido existe.
     *
     * @param id ID do grupo de categorias.
     * @return True se o grupo de categorias existir, caso contrário, lança uma exceção.
     * @throws Exception Se o grupo de categorias não for encontrado.
     */
    Boolean existCategoryGroupById(Long id) throws Exception;
}
