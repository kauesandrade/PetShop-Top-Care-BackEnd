package com.topcare.petshop.controller.dto.user;

import com.topcare.petshop.entity.*;

public record UserResponseDTO(

        String fullName,
        String email,
        String password,
        String cpf,
        UserRole role

) {
}
