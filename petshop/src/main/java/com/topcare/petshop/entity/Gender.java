package com.topcare.petshop.entity;

import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gender {
    MASCULINE("Masculino"),
    FEMININE("Feminino"),
    OTHER("Outro");

    private final String gender;
}
