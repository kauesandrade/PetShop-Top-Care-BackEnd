package com.topcare.petshop.entity;

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
    private Long Id;

    @Column(nullable = false)
    private String title;

    @OneToMany
    @Column(nullable = false)
    private List<ProductCategory> categorys;

//    @OneToOne
//    @Column(nullable = false)
//    private CategoryImage image;
}
