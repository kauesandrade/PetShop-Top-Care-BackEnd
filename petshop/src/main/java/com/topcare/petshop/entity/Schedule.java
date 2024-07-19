package com.topcare.petshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Pet pet;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Customer user;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Petshop petshop;

//    @OneToOne
//    @JoinColumn(nullable = false)
//    private Payment payment;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @ManyToMany
    private List<ServiceVariant> services;

}
