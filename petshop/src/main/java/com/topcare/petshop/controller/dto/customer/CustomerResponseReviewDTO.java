package com.topcare.petshop.controller.dto.customer;

public record CustomerResponseReviewDTO(
        String fullname,
        @lombok.NonNull byte[] customer_image
) {
}
