package com.topcare.petshop.entity;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
public enum UserRole {
    ADMIN ("Administrador"),
    MANAGER("Gerente"),
    VETERINARIAN("Veterinário"),
    CUSTOMER("Cliente");

    private final String role;

}
