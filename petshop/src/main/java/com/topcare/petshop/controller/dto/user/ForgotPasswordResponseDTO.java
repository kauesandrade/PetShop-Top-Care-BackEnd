package com.topcare.petshop.controller.dto.user;

public record ForgotPasswordResponseDTO(
        Long userId,
        Long code
) {
}
