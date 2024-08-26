package com.topcare.petshop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
/**
 * Enumeração que define os gêneros possíveis para um pet.
 */
@AllArgsConstructor
@Getter
public enum PetGender {
    MALE("Macho"),
    FEMALE("Fêmea");

    private final String gender;
}
