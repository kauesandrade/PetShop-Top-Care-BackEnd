package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.product.request.ProductRequestPostDTO;
import com.topcare.petshop.controller.dto.product.response.card.ProductResponseCardDTO;
import com.topcare.petshop.controller.dto.product.response.page.ProductResponsePageDTO;
import com.topcare.petshop.controller.dto.product.response.searchPage.ProductResponseSearchPageableDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/**
 * Representa um produto no sistema.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Código único do produto.
     */
    @Column(nullable = false)
    private Long code;

    /**
     * Indica se o produto está habilitado para venda.
     */
    @Column(nullable = false)
    private Boolean enabled = true;

    /**
     * Título do produto.
     */
    @Column(nullable = false, length = 150)
    private String title;

    /**
     * Descrição completa do produto.
     */
    @Column(nullable = false, length = 800)
    private String description;

    /**
     * Descrição curta do produto.
     */
    @Column(nullable = false, length = 100)
    private String shortDescription;

    /**
     * Marca do produto.
     */
    @ManyToOne
    @JoinColumn(nullable = false)
    private Brand brand;

    /**
     * Especificações do produto.
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", nullable = false)
    private List<ProductSpecification> specifications;

    /**
     * Avaliação média do produto.
     */
    private Double rating;

    /**
     * Categorias do produto.
     */
    @ManyToMany
    private List<ProductCategory> categories;

    /**
     * Avaliações do produto.
     */
    @OneToMany
    @JoinColumn(name = "product_id")
    private List<ProductReview> reviews;

    /**
     * Variedades do produto.
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private List<ProductVariant> variants;

    /**
     * Constrói um produto a partir dos dados do DTO e de outras entidades.
     *
     * @param productPostDTO Dados do produto.
     * @param brand Marca do produto.
     * @param productCategories Categorias do produto.
     * @param productSpecifications Especificações do produto.
     * @param productVariants Variedades do produto.
     */
    public Product(ProductRequestPostDTO productPostDTO, Brand brand, List<ProductCategory> productCategories, List<ProductSpecification> productSpecifications, List<ProductVariant> productVariants) {
        setCode(productPostDTO.code());
        setTitle(productPostDTO.title());
        setDescription(productPostDTO.description());
        setShortDescription(productPostDTO.shortDescription());
        setBrand(brand);
        setSpecifications(productSpecifications);
        setCategories(productCategories);
        setVariants(productVariants);
    }

    /**
     * Converte o produto para um DTO de página de busca paginável.
     *
     * @return DTO de página de busca paginável.
     */
    public ProductResponseSearchPageableDTO toSearchPageableDTO(){
        return new ProductResponseSearchPageableDTO(
                this.toCardDTO(),
                getCategories().stream().map(ProductCategory::toDTO).toList()
        );
    }

    /**
     * Converte o produto para um DTO de página.
     *
     * @return DTO de página.
     */
    public ProductResponsePageDTO toPageDTO(){
        return new ProductResponsePageDTO(
                getCode(),
                getTitle(),
                getDescription(),
                getShortDescription(),
                getBrand().toDTO(),
                getSpecifications().stream().map(ProductSpecification::toDTO).toList(),
                getRating(),
                getCategories().stream().map(ProductCategory::toDTO).toList(),
                getReviews().stream().map(ProductReview::toDTO).toList(),
                getVariants().stream().map(ProductVariant::toDTO).toList()
        );
    }

    /**
     * Alterna o status de habilitação do produto.
     */
    public void changeEnableProduct(){
        setEnabled(!getEnabled());
    }

    /**
     * Converte o produto para um DTO de cardápio.
     *
     * @return DTO de cardápio.
     */
    public ProductResponseCardDTO toCardDTO() {
        ProductImage productImage = new ProductImage();

        if (!getVariants().getFirst().getImages().isEmpty()){
            productImage = getVariants().getFirst().getImages().getFirst();
        }

        return new ProductResponseCardDTO(
                getCode(),
                getVariants().getFirst().getVariantCode(),
                getTitle(),
                getBrand().toDTO(),
                getVariants().getFirst().getPrice(),
                getVariants().getFirst().getDiscount(),
                2,
                getRating(),
                productImage
        );
    }
}
