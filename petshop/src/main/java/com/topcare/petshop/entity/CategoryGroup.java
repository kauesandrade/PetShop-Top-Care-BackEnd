package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.category.cateogoryGroup.CategoryGroupRequestDTO;
import com.topcare.petshop.controller.dto.category.cateogoryGroup.CategoryGroupResponseDTO;
import com.topcare.petshop.controller.dto.category.ProductCategoryResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Representa um grupo de categorias de produtos.
 */
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
    private List<ProductCategory> categories;

    @OneToOne
    @JoinColumn(nullable = false)
    private CategoryImage image;

    /**
     * Configura as categorias associadas ao grupo e ajusta a referência bidirecional.
     *
     * @param categories Lista de categorias a serem associadas.
     */
    public void setCategories(List<ProductCategory> categories) {
        this.categories = categories;
        categories.forEach(category -> {
            category.setCategoryGroup(this);
        });
    }

    /**
     * Constrói um CategoryGroup a partir de um DTO de solicitação e uma lista de categorias de produtos.
     *
     * @param categoryGroupDTO DTO de solicitação do grupo de categorias.
     * @param productCategories Lista de categorias de produtos associadas.
     */
    public CategoryGroup(CategoryGroupRequestDTO categoryGroupDTO, List<ProductCategory> productCategories) {
        setTitle(categoryGroupDTO.title());
        setCategories(productCategories);
        setImage(categoryGroupDTO.image());
    }

    /**
     * Converte o CategoryGroup para um DTO de resposta.
     *
     * @return DTO de resposta do grupo de categorias.
     */
    public CategoryGroupResponseDTO toDTO() {
        List<ProductCategoryResponseDTO> categoriesDTO = getCategories().stream()
                .map(ProductCategory::toDTO)
                .toList();

        return new CategoryGroupResponseDTO(
                getId(),
                getTitle(),
                categoriesDTO,
                getImage()
        );
    }

    /**
     * Atualiza o CategoryGroup com base em um DTO de solicitação e uma lista de categorias de produtos.
     *
     * @param categoryGroupDTO DTO de solicitação do grupo de categorias.
     * @param productCategories Lista de categorias de produtos associadas.
     */
    public void edit(CategoryGroupRequestDTO categoryGroupDTO, List<ProductCategory> productCategories) {
        setTitle(categoryGroupDTO.title());
        setCategories(productCategories);
    }
}
