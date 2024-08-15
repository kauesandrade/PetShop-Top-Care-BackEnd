package com.topcare.petshop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PetGender {
    MALE("Macho"),
    FEMALE("Fêmea");

    private String gender;
}
