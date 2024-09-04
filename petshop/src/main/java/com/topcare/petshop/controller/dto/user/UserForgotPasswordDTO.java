package com.topcare.petshop.controller.dto.user;

public record UserForgotPasswordDTO(

        Long id,
        String fullName,
        String email,
        String password,
        String cpf

) {
}
