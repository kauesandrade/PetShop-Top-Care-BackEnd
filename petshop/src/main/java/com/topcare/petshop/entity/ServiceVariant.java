package com.topcare.petshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Long variantCode;

    @Column(nullable = false, length = 60)
    private String variantTitle;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private LocalTime estimatedTime;

}
