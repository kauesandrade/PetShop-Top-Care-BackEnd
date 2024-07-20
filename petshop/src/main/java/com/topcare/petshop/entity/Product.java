package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.product.request.ProductRequestPostDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long code;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, length = 100)
    private String littleDescription;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Brand brand;

    @OneToMany
    @JoinColumn(name = "product_id", nullable = false)
    private List<ProductSpecification> specifications;

    private Double rating;

    @ManyToMany
    private List<ProductCategory> categories;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<ProductReview> reviews;

    public Product(ProductRequestPostDTO productPostDTO, Brand brand, List<ProductCategory> productCategories, List<ProductSpecification> productSpecifications) {
        setCode(productPostDTO.code());
        setTitle(productPostDTO.title());
        setDescription(productPostDTO.description());
        setLittleDescription(productPostDTO.littleDescription());
        setBrand(brand);
        setSpecifications(productSpecifications);
        setCategories(productCategories);
    }

}
