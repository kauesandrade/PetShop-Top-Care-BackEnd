package com.topcare.petshop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

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

    private String color;
}
