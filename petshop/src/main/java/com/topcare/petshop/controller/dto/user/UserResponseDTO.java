package com.topcare.petshop.controller.dto.user;

import com.topcare.petshop.entity.UserRole;

/**
 * DTO para retornar informações sobre um usuário.
 *
 * Campos:
 * - fullName: Nome completo do usuário.
 * - email: Endereço de e-mail do usuário.
 * - password: Senha do usuário.
 * - cpf: Número de CPF do usuário.
 * - role: Função ou papel do usuário no sistema (UserRole).
 *
 * Anotações:
 * - @param fullName: Nome completo do usuário.
 * - @param email: Endereço de e-mail do usuário.
 * - @param password: Senha do usuário.
 * - @param cpf: Número de CPF do usuário.
 * - @param role: Papel ou função do usuário dentro do sistema.
 */
public record UserResponseDTO(
        String fullName,
        String email,
        String password,
        String cpf,
        UserRole role
) {
}
