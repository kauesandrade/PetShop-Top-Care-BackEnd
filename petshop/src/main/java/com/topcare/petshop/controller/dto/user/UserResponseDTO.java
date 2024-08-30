package com.topcare.petshop.controller.dto.user;

import com.topcare.petshop.entity.*;

public record UserResponseDTO(
        Long id,
        String fullname,
        String email,
        String password,
        String cpf,
        UserRole role

) {
}
