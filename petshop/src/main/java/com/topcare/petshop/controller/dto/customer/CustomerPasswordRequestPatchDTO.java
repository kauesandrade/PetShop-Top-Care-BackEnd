package com.topcare.petshop.controller.dto.customer;

/**
 * DTO para enviar os dados de alteração de senha de um cliente.
 *
 * Campos:
 * - oldPassword: Senha antiga do cliente.
 * - newPassword: Nova senha do cliente.
 *
 * Anotações:
 * - @param oldPassword: A senha antiga do cliente para verificação.
 * - @param newPassword: A nova senha que o cliente deseja definir.
 */
public record CustomerPasswordRequestPatchDTO(String oldPassword, String newPassword) {
}
