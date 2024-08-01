package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.category.CategoryGroupRequestPostDTO;
import com.topcare.petshop.controller.dto.category.CategoryGroupResponseDTO;
import com.topcare.petshop.controller.dto.category.CategoryResponseDTO;
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_group_id", nullable = false)
    private List<ProductCategory> categories;

    @OneToOne
    @JoinColumn(nullable = false)
    private CategoryImage image;

    public CategoryGroup(CategoryGroupRequestPostDTO categoryGroupDTO, List<ProductCategory> productCategories) {
        setTitle(categoryGroupDTO.title());
        setCategories(productCategories);
        setImage(categoryGroupDTO.image());
    }

    public CategoryGroupResponseDTO toDTO(){
        List<CategoryResponseDTO> categoriesDTO = getCategories().stream().map(
                productCategory -> productCategory.toDTO()).toList();

        return new CategoryGroupResponseDTO(
                getTitle(),
                categoriesDTO,
                getImage()
        );
    }
}
