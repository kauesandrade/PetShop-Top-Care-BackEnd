package com.topcare.petshop.controller.dto.card;

import java.time.LocalDate;

public record CardResponseDTO(
        Long id,
        String name,
        String lastDigits,
        LocalDate expirationDate,
        Boolean mainCard
) {}
