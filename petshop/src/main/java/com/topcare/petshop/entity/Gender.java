package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.customer.CustomerRequestPostDTO;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
/**
 * Enumeração que define os gêneros possíveis para um cliente.
 */
@AllArgsConstructor
@Getter
public enum Gender {

    MASCULINE("Masculino"),
    FEMININE("Feminino"),
    OTHER("Outro");

    private final String gender;

    /**
     * Define o gênero com base em uma string fornecida.
     *
     * @param gender String representando o gênero.
     * @return Gender correspondente ao valor fornecido.
     */
    public static Gender defineGender(String gender) {
        switch (gender.toLowerCase()) {
            case "masculino":
                return MASCULINE;
            case "feminino":
                return FEMININE;
            default:
                return OTHER;
        }
    }
}

