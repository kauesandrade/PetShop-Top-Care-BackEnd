package com.topcare.petshop.entity;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enum UserRole define os diferentes papéis que um usuário pode ter no sistema.
 *
 * Cada papel possui um nome que identifica o tipo de usuário (Ex: Administrador, Cliente).
 *
 * Anotações:
 * - @AllArgsConstructor: Gera um construtor com todos os atributos da enumeração.
 * - @Getter: Gera automaticamente os métodos getters para acessar os valores da enumeração.
 * - @Inheritance(strategy = InheritanceType.JOINED): Define a estratégia de herança para os papéis de usuário.
 */
@AllArgsConstructor
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
public enum UserRole {
    ADMIN ("Administrador"),
    MANAGER("Gerente"),
    VETERINARIAN("Veterinário"),
    CUSTOMER("Cliente");

    private String role; /** Nome do papel do usuário */

}
