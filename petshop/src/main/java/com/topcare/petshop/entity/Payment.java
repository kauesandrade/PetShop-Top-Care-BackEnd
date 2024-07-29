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
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double subTotal;

    @Column(nullable = false)
    private Double shippingFee;

    @Column(nullable = false)
    private Double total;

    @ManyToOne
    private PaymentMethod method;

    @Column(nullable = false)
    private Integer parcels;

    @Enumerated
    private PaymentStatus status;

}
