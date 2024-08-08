package com.topcare.petshop.controller.dto.productReview;

import com.topcare.petshop.entity.Customer;

import java.time.LocalDate;

public record ProductReviewGetDTO (

        Customer customer,
        String review,
        Integer rating,
        LocalDate creationDate

){
}
