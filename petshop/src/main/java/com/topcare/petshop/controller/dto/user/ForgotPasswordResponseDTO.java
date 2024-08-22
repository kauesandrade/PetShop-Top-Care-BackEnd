package com.topcare.petshop.controller.dto.user;

/**
 * DTO para resposta ao solicitar recuperação de senha.
 *
 * Campos:
 * - userId: Identificador do usuário que solicitou a recuperação de senha.
 * - code: Código gerado para o processo de recuperação de senha.
 *
 * Anotações:
 * - @param userId: ID do usuário para o qual a recuperação de senha foi solicitada.
 * - @param code: Código de recuperação de senha gerado para o usuário.
 */
public record ForgotPasswordResponseDTO(
        Long userId,
        Long code
) {
}
