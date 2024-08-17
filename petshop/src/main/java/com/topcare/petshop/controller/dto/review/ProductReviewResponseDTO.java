package com.topcare.petshop.controller.dto.review;

import java.time.LocalDate;

public record ProductReviewResponseDTO(
        String customer,
        String review,
        Integer rating,
        LocalDate reviewDate
) {
}
