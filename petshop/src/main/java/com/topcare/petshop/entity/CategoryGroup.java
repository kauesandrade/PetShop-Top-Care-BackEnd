package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.category.cateogoryGroup.CategoryGroupRequestDTO;
import com.topcare.petshop.controller.dto.category.cateogoryGroup.CategoryGroupResponseDTO;
import com.topcare.petshop.controller.dto.category.ProductCategoryResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryGroup")
//    @JoinColumn(name = "category_group_id", nullable = false)
    private List<ProductCategory> categories;

    @OneToOne
    @JoinColumn(nullable = false)
    private CategoryImage image;


    public void setCategories(List<ProductCategory> categories) {
        this.categories = categories;
        categories.forEach(category -> {
            category.setCategoryGroup(this);
        });
    }

    public CategoryGroup(CategoryGroupRequestDTO categoryGroupDTO, List<ProductCategory> productCategories) {
        setTitle(categoryGroupDTO.title());
        setCategories(productCategories);
        setImage(categoryGroupDTO.image());
    }

    public CategoryGroupResponseDTO toDTO(){
        List<ProductCategoryResponseDTO> categoriesDTO = getCategories().stream().map(
                productCategory -> productCategory.toDTO()).toList();

        return new CategoryGroupResponseDTO(
                getId(),
                getTitle(),
                categoriesDTO,
                getImage()
        );
    }

    public void edit(CategoryGroupRequestDTO categoryGroupDTO, List<ProductCategory> productCategories) {
        setTitle(categoryGroupDTO.title());
        setCategories(productCategories);
//        setImage(categoryGroupDTO.image());
    }
}
