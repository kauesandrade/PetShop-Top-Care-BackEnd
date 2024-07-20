package com.topcare.petshop.entity;

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
    private Boolean available;
}
