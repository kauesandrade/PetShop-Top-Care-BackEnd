package com.topcare.petshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Petshop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(nullable = false)
    private PetshopImage image;

    @Column(nullable = false, length = 50)
    private String name;

    @OneToOne
    @JoinColumn(nullable = false)
    private PetshopAddress address;

//    Ver com o romário
//    private OpeningHours openingHours;

    @Column(nullable = false, length = 11)
    private String telephone;

}
