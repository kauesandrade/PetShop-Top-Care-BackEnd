package com.topcare.petshop.controller.dto.productReview;

import com.topcare.petshop.entity.Customer;
import com.topcare.petshop.entity.Product;

import java.time.LocalDate;

public record ProductReviewPostDTO(

        Customer customerId,
        String review,
        Integer rating

) {
}
