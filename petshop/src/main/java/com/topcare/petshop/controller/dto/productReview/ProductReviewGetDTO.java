package com.topcare.petshop.controller.dto.productReview;

import com.topcare.petshop.entity.Customer;
import com.topcare.petshop.entity.Product;

import java.time.LocalDate;

public record ProductReviewGetDTO (

        Customer customer,
        String review,
        Integer rating,
        LocalDate creationDate

){
}
