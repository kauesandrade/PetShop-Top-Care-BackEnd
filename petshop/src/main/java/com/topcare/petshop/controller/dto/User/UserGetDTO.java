package com.topcare.petshop.controller.dto.User;

import com.topcare.petshop.entity.*;

import java.time.LocalDate;
import java.util.List;

public record UserGetDTO(

        String fullName,
        String email,
        String password,
        String cpf,
        UserRole role

) {
}
