package com.topcare.petshop.controller.dto.card;

import java.time.LocalDate;

public record CardRequestDTO(

        String name,
        String lastDigits,
        LocalDate expirationDate,
        Boolean mainCard,
        Long userId

) {
}
