package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.product.request.ProductRequestPostDTO;
import com.topcare.petshop.controller.dto.product.request.ProductVariantRequestPostDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductVariant extends Product {

    @Column(nullable = false)
    private Long variantCode;

    @Column(nullable = false)
    private String variantTitle;

    @OneToMany
    @JoinColumn(name = "product_variant_id", nullable = false)
    private List<ProductImage> images;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Double discountPrice;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Boolean available;


    public ProductVariant(ProductVariantRequestPostDTO productVariant, Product product) {
        setVariantCode(productVariant.variantCode());
        setVariantTitle(productVariant.variantTitle());
        setPrice(productVariant.price());
        setImages(productVariant.images());
        setDiscountPrice(productVariant.discount());
        setStock(productVariant.amountStock());

        if(stock > 0){
            setAvailable(true);
        }else {
            setAvailable(false);
        }

        setCode(product.getCode());
        setTitle(product.getTitle());
        setDescription(product.getDescription());
        setLittleDescription(product.getLittleDescription());
        setBrand(product.getBrand());
        setSpecifications(null);
        setCategories(product.getCategories());
    }
}
