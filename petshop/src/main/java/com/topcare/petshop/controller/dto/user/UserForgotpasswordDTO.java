package com.topcare.petshop.controller.dto.user;

import com.topcare.petshop.entity.UserRole;

public record UserForgotpasswordDTO(

        Long id,
        String fullName,
        String email,
        String password,
        String cpf

) {
}
