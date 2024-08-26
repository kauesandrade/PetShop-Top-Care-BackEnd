package com.topcare.petshop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
/**
 * Enumeração que define as cores possíveis para um pet.
 */
@AllArgsConstructor
@Getter
public enum PetColor {
    RED("pet-red"),
    ORANGE("pet-orange"),
    YELLOW("pet-yellow"),
    BLUE("pet-blue"),
    LIGHT_BLUE("pet-light-blue"),
    GREEN("pet-green"),
    LIGHT_GREEN("pet-light-green"),
    GREY("pet-grey"),
    PINK("pet-pink"),
    PURPLE("pet-purple");

    private final String color;
}
