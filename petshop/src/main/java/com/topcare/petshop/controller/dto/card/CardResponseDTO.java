package com.topcare.petshop.controller.dto.card;

import java.time.LocalDate;

/**
 * A classe CardResponseDTO é um DTO (Data Transfer Object) utilizado para retornar
 * os dados de um cartão de pagamento ao buscar informações de um cartão no sistema de pet shop.
 *
 * Campos:
 * - id: Identificador único do cartão.
 * - name: Nome do titular do cartão.
 * - lastDigits: Últimos dígitos do número do cartão.
 * - expirationDate: Data de expiração do cartão.
 * - mainCard: Indica se o cartão é o principal para o usuário.
 *
 * Anotações:
 * - @param id: ID único do cartão.
 * - @param name: Nome do titular do cartão.
 * - @param lastDigits: Últimos dígitos do cartão.
 * - @param expirationDate: Data de expiração do cartão.
 * - @param mainCard: Booleano que indica se o cartão é o principal do usuário.
 */
public record CardResponseDTO(
        Long id,
        String name,
        String lastDigits,
        LocalDate expirationDate,
        Boolean mainCard
) {
}
