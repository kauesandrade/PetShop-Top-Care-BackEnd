package com.topcare.petshop.controller.dto.product.response.page;

/**
 * DTO para retornar uma especificação de produto em uma página.
 *
 * Campos:
 * - title: Título da especificação.
 * - description: Descrição da especificação.
 *
 * Anotações:
 * - @param title: Título da especificação do produto.
 * - @param description: Descrição detalhada da especificação.
 */
public record ProductSpecificationResponsePageDTO(

        Long id,
        String title,
        String description
) {
}
