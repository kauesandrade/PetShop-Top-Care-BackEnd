package com.topcare.petshop.controller.dto.user;

/**
 * DTO para criar um novo usuário com e-mail e senha.
 *
 * Campos:
 * - email: Endereço de e-mail do usuário.
 * - password: Senha do usuário.
 *
 * Anotações:
 * - @param email: Endereço de e-mail do novo usuário.
 * - @param password: Senha do novo usuário.
 */
public record UserRequestPostDTO(
        String email,
        String password
) {
}
