package com.topcare.petshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 8)
    private String cep;

    @Column(nullable = false)
    @Enumerated
    private State state;

    @Column(nullable = false, length = 40)
    private String city;

    @Column(nullable = false, length = 50)
    private String neighborhood;

    @Column(nullable = false, length = 50)
    private String street;

    @Column(nullable = false, length = 5)
    private String number;

    @Column(length = 150)
    private String complement;
}
