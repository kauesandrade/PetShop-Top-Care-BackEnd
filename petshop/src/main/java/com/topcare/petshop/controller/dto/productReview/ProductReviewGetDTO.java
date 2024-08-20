package com.topcare.petshop.controller.dto.productReview;

import com.topcare.petshop.controller.dto.customer.CustomerProductReviewDTO;

import java.time.LocalDate;

public record ProductReviewGetDTO (

        CustomerProductReviewDTO customer,
        String review,
        Integer rating,
        LocalDate creationDate

){
}
