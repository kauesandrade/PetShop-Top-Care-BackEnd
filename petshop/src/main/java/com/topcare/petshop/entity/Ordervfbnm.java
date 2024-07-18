package com.topcare.petshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ordervfbnm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Long codigo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "order_id")
    private List<OrderItem> items;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Address deliveryAddress;

    @Column(nullable = false)
    private LocalDate expectedDeliveryDate;

//    @OneToOne(cascade = CascadeType.ALL)
//    @Column(nullable = false)
//    private Payment payment;

    @CreationTimestamp
    private LocalDate orderDate;

//    @OneToOne(cascade = CascadeType.ALL)
//    private Shipping shipping;

}
