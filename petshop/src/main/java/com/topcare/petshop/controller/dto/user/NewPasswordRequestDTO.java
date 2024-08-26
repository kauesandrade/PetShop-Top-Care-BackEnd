package com.topcare.petshop.controller.dto.user;

/**
 * DTO para solicitar a alteração de senha do usuário.
 *
 * Campos:
 * - newPassword: Nova senha que o usuário deseja definir.
 *
 * Anotações:
 * - @param newPassword: Nova senha a ser definida pelo usuário.
 */
public record NewPasswordRequestDTO(
        String newPassword
) {
}
