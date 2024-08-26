package com.topcare.petshop.controller.dto.card;

import java.time.LocalDate;

/**
 * A classe CardRequestDTO é um DTO (Data Transfer Object) utilizado para enviar
 * os dados de um cartão de pagamento ao criar ou atualizar um cartão no sistema de pet shop.
 *
 * Campos:
 * - name: Nome do titular do cartão.
 * - lastDigits: Últimos dígitos do número do cartão.
 * - expirationDate: Data de expiração do cartão.
 * - mainCard: Indica se o cartão é o principal para o usuário.
 * - userId: Identificador do usuário associado ao cartão.
 *
 * Anotações:
 * - @param name: Nome do titular do cartão.
 * - @param lastDigits: Últimos dígitos do cartão (normalmente os 4 últimos dígitos).
 * - @param expirationDate: Data de expiração do cartão.
 * - @param mainCard: Booleano que indica se é o cartão principal do usuário.
 * - @param userId: ID do usuário ao qual o cartão está associado.
 */
public record CardRequestDTO(
        String name,
        String lastDigits,
        LocalDate expirationDate,
        Boolean mainCard,
        Long userId
) {
}
