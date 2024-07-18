package com.topcare.petshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Subscriptiondfghjkl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Long code;

    @Enumerated
    private SubscriptionInterval interval;

    @Column(nullable = false)
    private LocalDate nextShippingDate;

//    @OneToOne
//    @Column(nullable = false)
//    private Payment payment;

}
