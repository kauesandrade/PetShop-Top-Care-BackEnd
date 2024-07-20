package com.topcare.petshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends User {

    @OneToOne
    private CustomerImage profileImage;

    @Column(nullable = false)
    private LocalDate birth;

    @Column(nullable = false)
    @Enumerated
    private Gender gender;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    private List<Contact> contactInfo;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CustomerAddress> addresses;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private List<Card> cards;

    @OneToMany
    @JoinColumn(name = "customer_id")
    private List<CustomerOrder> orders;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private List<Subscription> subscriptions;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private List<Pet> pets;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<ProductVariant> favorites;

    @OneToOne
    private Cart cart;
}
