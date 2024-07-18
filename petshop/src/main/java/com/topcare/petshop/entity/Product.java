package com.topcare.petshop.entity;

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
    @Column(nullable = false)
    private List<ProductSpecification> specifications;

    private Double rating;

    @ManyToMany
    @Column(nullable = false)
    private List<ProductCategory> categorys;

    @OneToMany
    private List<ProductReview> reviews;
}
