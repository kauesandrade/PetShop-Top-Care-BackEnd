package com.topcare.petshop.controller.dto.user;

/**
 * DTO para solicitar o envio de um e-mail para o usuário.
 *
 * Campos:
 * - email: Endereço de e-mail do usuário.
 *
 * Anotações:
 * - @param email: Endereço de e-mail associado ao usuário.
 */
public record UserEmailRequestDTO(
        String email
) {
}
