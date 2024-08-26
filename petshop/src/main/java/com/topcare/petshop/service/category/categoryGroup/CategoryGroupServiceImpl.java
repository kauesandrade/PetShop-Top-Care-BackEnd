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

@Service
@AllArgsConstructor
public class CategoryGroupServiceImpl implements CategoryGroupServiceInt {

    private final CategoryGroupRepository repository;
    private final ProductCategoryServiceImpl categoryService;
    private final SearchServiceImpl searchService;
    private final ProductServiceImpl productService;

    @Override
    public CategoryGroupResponseDTO getCategoryGroupById(Long id) throws Exception {
        existCategoryGroupById(id);
        return repository.findById(id).get().toDTO();
    }

    @Override
    public List<CategoryGroupResponseDTO> getAllCategoriesGroup() {
        return repository.findAll().stream().map(categoryGroup
                -> categoryGroup.toDTO()).toList();
    }

    @Override
    public CategoryGroupResponseDTO createCategoryGroup(CategoryGroupRequestDTO categoryGroupDTO) throws Exception {

        try {
            List<ProductCategory> productCategories = categoryGroupDTO
                    .categories();
            CategoryGroup categoryGroup = new CategoryGroup(categoryGroupDTO, productCategories);

            return repository.save(categoryGroup).toDTO();
        }catch (Exception e){
            throw new Exception("Não foi possível cria o grupo de categorias!");
        }
    }

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

    @Override
    public void deleteCategoryGroupById(Long id) throws Exception {
        existCategoryGroupById(id);

        for(ProductCategory productCategory : categoryService.getAllProductCategoryByCategoryGroup(repository.findById(id).get().getId())){
            categoryService.deleteProductCategoryById(productCategory.getId());
        }

        repository.deleteById(id);
    }

    @Override
    public Boolean existCategoryGroupById(Long id) throws Exception {
        if (id == null || !repository.existsById(id)){
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

    private void deleteCategory(List<ProductCategory> newListCategory, List<ProductCategory> oldListCategory){

        for (ProductCategory oldCategory : oldListCategory){

            boolean exist = false;

            for (ProductCategory newCategory : newListCategory){
                try {
                    if(Objects.equals(oldCategory.getId(), newCategory.getId()) &&
                            categoryService.existProductCategoryById(oldCategory.getId())){
                        exist = true;
                        break;
                    }
                }catch (Exception ignored){}
            }

            try {
                if (!exist){
                    System.out.println(oldCategory.getId());
                    categoryService.deleteProductCategoryById(oldCategory.getId());
                }
            }catch (Exception ignored){}
        }

    }

    private void checkCategoryWithGroup(List<ProductCategory> productCategoryList, Long categoryGroupId) throws Exception {
        for(ProductCategory category : productCategoryList){
            if(categoryService.existProductCategoryById(category.getId())){
                if(!Objects.equals(categoryService.getProductCategoryById(category.getId()).getCategoryGroup().getId(), categoryGroupId)){
                    throw new Exception("A categoria que deseja alterar não pertence a esse grupo!");
                }
            }
        }
    }

}
