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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long code;

    @Column(nullable = false)
    private Boolean enabled = true;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = false, length = 800)
    private String description;

    @Column(nullable = false, length = 100)
    private String shortDescription;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Brand brand;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", nullable = false)
    private List<ProductSpecification> specifications;

    private Double rating;

    @ManyToMany
    private List<ProductCategory> categories;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<ProductReview> reviews;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private List<ProductVariant> variants;

    public Product(ProductRequestPostDTO productPostDTO, Brand brand, List<ProductCategory> productCategories, List<ProductSpecification> productSpecifications,  List<ProductVariant> productVariants) {
        setCode(productPostDTO.code());
        setTitle(productPostDTO.title());
        setDescription(productPostDTO.description());
        setShortDescription(productPostDTO.shortDescription());
        setBrand(brand);
        setSpecifications(productSpecifications);
        setCategories(productCategories);
        setVariants(productVariants);
    }

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

    public void changeEnableProduct(){
        setEnabled(!getEnabled());
    }

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
