package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.customer.CustomerRequestPostDTO;
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

    private String gender;

    public static Gender defineGender(String gender) {
        if (gender.equalsIgnoreCase("masculino")) {
            return MASCULINE;
        } else if (gender.equalsIgnoreCase("feminino")) {
            return FEMININE;
        } else {
            return OTHER;
        }
    }
}
