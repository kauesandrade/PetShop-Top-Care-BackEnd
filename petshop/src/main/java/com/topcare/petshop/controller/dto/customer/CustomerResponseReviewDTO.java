package com.topcare.petshop.controller.dto.customer;

/**
 * DTO para retornar uma visão resumida de um cliente, usada para exibir informações em uma revisão.
 *
 * Campos:
 * - fullname: Nome completo do cliente.
 * - customer_image: Imagem do cliente em formato de byte array.
 *
 * Anotações:
 * - @param fullname: Nome completo do cliente.
 * - @param customer_image: Imagem do cliente em formato byte array.
 */
public record CustomerResponseReviewDTO(
        String fullname,
        @lombok.NonNull byte[] customer_image
) {
}
