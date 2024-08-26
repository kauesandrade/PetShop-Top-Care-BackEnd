package com.topcare.petshop.service.category.categoryGroup;

import com.topcare.petshop.controller.dto.category.cateogoryGroup.CategoryGroupFiltersResponseDTO;
import com.topcare.petshop.controller.dto.category.cateogoryGroup.CategoryGroupRequestDTO;
import com.topcare.petshop.controller.dto.category.cateogoryGroup.CategoryGroupResponseDTO;
import com.topcare.petshop.entity.CategoryGroup;
import com.topcare.petshop.entity.Product;
import com.topcare.petshop.entity.ProductCategory;
import com.topcare.petshop.repository.CategoryGroupRepository;
import com.topcare.petshop.repository.ProductCategoryRepository;
import com.topcare.petshop.service.category.ProductCategoryServiceImpl;
import com.topcare.petshop.service.product.ProductServiceImpl;
import com.topcare.petshop.service.search.SearchServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
/**
 * Implementa os serviços relacionados à entidade {@link CategoryGroup}.
 * Fornece métodos para manipulação de grupos de categorias, incluindo criação, leitura, atualização e exclusão.
 */
@Service
@AllArgsConstructor
public class CategoryGroupServiceImpl implements CategoryGroupServiceInt {

    private final CategoryGroupRepository repository;
    private final ProductCategoryServiceImpl categoryService;
    private final SearchServiceImpl searchService;
    private final ProductServiceImpl productService;

    /**
     * Retorna um DTO do grupo de categorias com o ID fornecido.
     *
     * @param id ID do grupo de categorias.
     * @return DTO do grupo de categorias.
     * @throws Exception Se o grupo de categorias não for encontrado.
     */
    @Override
    public CategoryGroupResponseDTO getCategoryGroupById(Long id) throws Exception {
        existCategoryGroupById(id);
        return repository.findById(id).get().toDTO();
    }

    /**
     * Retorna uma lista de todos os grupos de categorias convertidos para DTOs.
     *
     * @return Lista de DTOs dos grupos de categorias.
     */
    @Override
    public List<CategoryGroupResponseDTO> getAllCategoriesGroup() {
        return repository.findAll().stream().map(CategoryGroup::toDTO).toList();
    }

    /**
     * Cria um novo grupo de categorias com base no DTO fornecido.
     *
     * @param categoryGroupDTO DTO do grupo de categorias a ser criado.
     * @return DTO do grupo de categorias criado.
     * @throws Exception Se ocorrer um erro durante a criação do grupo de categorias.
     */
    @Override
    public CategoryGroupResponseDTO createCategoryGroup(CategoryGroupRequestDTO categoryGroupDTO) throws Exception {
        try {
            List<ProductCategory> productCategories = categoryGroupDTO.categories();
            CategoryGroup categoryGroup = new CategoryGroup(categoryGroupDTO, productCategories);

            return repository.save(categoryGroup).toDTO();
        } catch (Exception e) {
            throw new Exception("Não foi possível criar o grupo de categorias!");
        }
    }

    /**
     * Edita um grupo de categorias existente com base no ID e no DTO fornecidos.
     *
     * @param id ID do grupo de categorias a ser editado.
     * @param categoryGroupDTO DTO com as novas informações.
     * @return DTO do grupo de categorias editado.
     * @throws Exception Se o grupo de categorias não for encontrado ou ocorrer um erro.
     */
    @Override
    public CategoryGroupResponseDTO editCategoryGroup(Long id, CategoryGroupRequestDTO categoryGroupDTO) throws Exception {
        existCategoryGroupById(id);

        CategoryGroup categoryGroup = repository.findById(id).get();
        List<ProductCategory> newProductCategories = categoryGroupDTO.categories();

        checkCategoryWithGroup(newProductCategories, categoryGroup.getId());
        deleteCategory(newProductCategories, categoryGroup.getCategories());
        categoryGroup.edit(categoryGroupDTO, newProductCategories);

        return repository.save(categoryGroup).toDTO();
    }

    /**
     * Exclui um grupo de categorias pelo ID.
     * Também exclui todas as categorias associadas ao grupo.
     *
     * @param id ID do grupo de categorias a ser excluído.
     * @throws Exception Se o grupo de categorias não for encontrado ou ocorrer um erro.
     */
    @Override
    public void deleteCategoryGroupById(Long id) throws Exception {
        existCategoryGroupById(id);

        for (ProductCategory productCategory : categoryService.getAllProductCategoryByCategoryGroup(repository.findById(id).get().getId())) {
            categoryService.deleteProductCategoryById(productCategory.getId());
        }

        repository.deleteById(id);
    }

    /**
     * Verifica se um grupo de categorias com o ID fornecido existe.
     *
     * @param id ID do grupo de categorias.
     * @return True se o grupo de categorias existir, caso contrário, lança uma exceção.
     * @throws Exception Se o grupo de categorias não for encontrado.
     */
    @Override
    public Boolean existCategoryGroupById(Long id) throws Exception {
        if (id == null || !repository.existsById(id)) {
            throw new Exception("O grupo de categorias não foi encontrado!");
        }
        return true;
    }

    @Override
    public List<CategoryGroupFiltersResponseDTO> getFilters(String searchValue) {

        List<Product> products =
                searchService.searchProducts(productService.getAllProducts(), searchValue);

        HashMap<Long, ProductCategory> productCategoryHashMap = new HashMap<>();
        HashMap<String, List<ProductCategory>> categoriesHashMap = new HashMap<>();

        products.stream().map(Product::getCategories).forEach(productCategoryList ->{
            productCategoryList.stream().forEach(productCategory -> {
                productCategoryHashMap.put(productCategory.getId(), productCategory);
            });
        });

        productCategoryHashMap.forEach((aLong, productCategory) -> {
            if (!categoriesHashMap.containsKey(productCategory.getCategoryGroup().getTitle())){
                List<ProductCategory> newProductCategories = new ArrayList<>();
                newProductCategories.add(productCategory);
                categoriesHashMap.put(productCategory.getCategoryGroup().getTitle(), newProductCategories);
            }else {
                List<ProductCategory> productCategories = categoriesHashMap.get(productCategory.getCategoryGroup().getTitle());
                productCategories.add(productCategory);
                categoriesHashMap.put(productCategory.getCategoryGroup().getTitle(), productCategories);
            }
        });

        List<CategoryGroupFiltersResponseDTO> filtes = new ArrayList<>();

        categoriesHashMap.forEach((string, productCategoryList) -> {
            filtes.add(new CategoryGroupFiltersResponseDTO(string, productCategoryList.stream().map(ProductCategory::toDTO).toList()));
        });

        return filtes;
    }
    /**
     * Exclui categorias que não estão mais associadas ao grupo de categorias.
     *
     * @param newListCategory Nova lista de categorias.
     * @param oldListCategory Lista antiga de categorias.
     */
    private void deleteCategory(List<ProductCategory> newListCategory, List<ProductCategory> oldListCategory){

        for (ProductCategory oldCategory : oldListCategory){
            boolean exist = false;
            for (ProductCategory newCategory : newListCategory) {
                try {
                    if (Objects.equals(oldCategory.getId(), newCategory.getId()) &&
                            categoryService.existProductCategoryById(oldCategory.getId())) {
                        exist = true;
                        break;
                    }
                } catch (Exception ignored) {}
            }
            try {
                if (!exist) {
                    categoryService.deleteProductCategoryById(oldCategory.getId());
                }
            } catch (Exception ignored) {}
        }
    }

    /**
     * Verifica se todas as categorias fornecidas pertencem ao grupo de categorias especificado.
     *
     * @param productCategoryList Lista de categorias a verificar.
     * @param categoryGroupId ID do grupo de categorias.
     * @throws Exception Se alguma categoria não pertencer ao grupo.
     */
    private void checkCategoryWithGroup(List<ProductCategory> productCategoryList, Long categoryGroupId) throws Exception {
        for (ProductCategory category : productCategoryList) {
            if (categoryService.existProductCategoryById(category.getId())) {
                if (!Objects.equals(categoryService.getProductCategoryById(category.getId()).getCategoryGroup().getId(), categoryGroupId)) {
                    throw new Exception("A categoria que deseja alterar não pertence a esse grupo!");
                }
            }
        }
    }
}
