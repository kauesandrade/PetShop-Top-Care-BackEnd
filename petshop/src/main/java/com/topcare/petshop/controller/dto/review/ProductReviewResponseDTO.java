package com.topcare.petshop.controller.dto.review;

import com.topcare.petshop.controller.dto.customer.CustomerResponseReviewDTO;

import java.time.LocalDate;

public record ProductReviewResponseDTO(
        CustomerResponseReviewDTO customer,
        String review,
        Integer rating,
        LocalDate reviewDate
) {
}
