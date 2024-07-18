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
public class Customer extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToOne
//    private CustomerImage profileImage;

    @Column(nullable = false)
    private LocalDate birth;

    @Column(nullable = false)
    private Gender gender;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(nullable = false)
//    private List<Contact> contactInfo;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(nullable = false)
//    private List<Address> addresses;

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Card> cards;

//    @OneToMany
//    private List<Order> orders;

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Subscription> subscriptions;

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Pet> pets;

//    @ManyToMany(cascade = CascadeType.ALL)
//    private List<Product> favorities;
}
