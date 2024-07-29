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
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shippingCode;

    private String shippingBy;

    @ManyToOne
    @JoinColumn(nullable = false)
    private ShippingType shippingType;

    @ManyToMany
    private List<ShippingStatus> shippingStatus;

}
