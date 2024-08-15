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
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Long code;

    @OneToOne
    @JoinColumn(name = "image_id", nullable = false)
    private ServiceImage image;

    @Column(nullable = false, length = 35)
    private String title;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(nullable = false)
    private ServiceCategory category;

    @ManyToMany
    private List<PetType> servedPets;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_id")
    private List<ServiceVariant> variants;

}
