package com.topcare.petshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    @Column(nullable = false)
    private PetColor idColor;

    @OneToOne
    @JoinColumn(nullable = false)
    private PetImage image;

    @Column(nullable = false, length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(nullable = false)
    private PetType type;

    @Column(length = 50)
    private String race;

    @Column(length = 20)
    private String size;

    @Column(unique = true)
    private String microchip;

    @Enumerated
    private PetGender gender;

    @Column(length = 30)
    private String color;

    private LocalDate birth;

    @Column(unique = true)
    private String rga;

    // Em kilos
    private Double weight;

    @OneToMany(mappedBy = "pet")
    private List<Schedule> schedules;

}
