package com.topcare.petshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.topcare.petshop.controller.dto.product.request.ProductRequestPostDTO;
import com.topcare.petshop.controller.dto.product.response.ProductResponseDTO;
import com.topcare.petshop.controller.dto.product.response.ProductResponseSearchPageableDTO;
import com.topcare.petshop.controller.dto.product.response.ProductVariantResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    public ProductResponseSearchPageableDTO toSearchPageableDTO(){
        return new ProductResponseSearchPageableDTO(
                getCode(),
                getTitle(),
                getVariants().get(0).getPrice(),
                getVariants().get(0).getDiscount(),
                2,
                getBrand().toDTO(),
                getRating(),
                getCategories().stream().map(ProductCategory::toDTO).toList()
        );
    }

    public ProductResponseDTO toDTO(){

        return new ProductResponseDTO(
                getCode(),
                getTitle(),
                getDescription(),
                getShortDescription(),
                getBrand().toDTO(),
                getSpecifications(),
                getRating(),
                getCategories().stream().map(ProductCategory::toDTO).toList(),
                getReviews().stream().map(ProductReview::toDTO).toList(),
                getVariants().stream().map(ProductVariant::toDTO).toList()
        );
    }

    public void changeEnableProduct(){
        setEnabled(!getEnabled());
    }

}
