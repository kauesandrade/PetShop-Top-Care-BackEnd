package com.topcare.petshop.controller.dto;

import com.topcare.petshop.entity.*;

import java.time.LocalDate;
import java.util.List;

public record UserGetDTO(
//        CustomerImage profileImage

        LocalDate birth,
        Gender gender,
        List<Contact> contactInfo,
        List<Address> addresses,
        List<Card> cards
//        List<Order> orders,
//        List<Subscription> subscriptions,
//        List<Pet> pets,
//        List<Product> products
) {
}
