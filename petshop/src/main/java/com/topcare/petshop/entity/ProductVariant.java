package com.topcare.petshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductVariant extends Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long variantCode;

//    @OneToMany
//    @Column(nullable = false)
//    private List<ProductImage> images;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Double discountPrice;

    @Column(nullable = false)
    private boolean available;
}
