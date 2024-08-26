package com.topcare.petshop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enum State representa os estados brasileiros.
 *
 * Cada enum é um estado com seu nome completo.
 *
 * Anotações:
 * - @AllArgsConstructor: Gera um construtor com todos os atributos da enumeração.
 * - @Getter: Gera automaticamente os métodos getters para acessar os valores da enumeração.
 */
@AllArgsConstructor
@Getter
public enum State {

    AC("Acre"),
    AL("Alagoas"),
    AP("Amapá"),
    AM("Amazonas"),
    BA("Bahia"),
    CE("Ceará"),
    DF("Distrito Federal"),
    ES("Espírito Santo"),
    GO("Goiás"),
    MA("Maranhão"),
    MT("Mato Grosso"),
    MS("Mato Grosso do Sul"),
    MG("Minas Gerais"),
    PA("Pará"),
    PB("Paraíba"),
    PR("Paraná"),
    PE("Pernambuco"),
    PI("Piauí"),
    RJ("Rio de Janeiro"),
    RN("Rio Grande do Norte"),
    RS("Rio Grande do Sul"),
    RO("Rondônia"),
    RR("Roraima"),
    SC("Santa Catarina"),
    SP("São Paulo"),
    SE("Sergipe"),
    TO("Tocantins");

    private final String state; /** Nome completo do estado*/

}
