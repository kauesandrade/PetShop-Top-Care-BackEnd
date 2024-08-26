package com.topcare.petshop.controller.dto.category;

/**
 * DTO para retornar os dados de uma categoria de produto.
 *
 * Campos:
 * - id: Identificador único da categoria.
 * - title: Título da categoria.
 *
 * Anotações:
 * - @param id: ID único da categoria de produto.
 * - @param title: O título da categoria de produto.
 */
public record ProductCategoryResponseDTO(
        Long id,
        String title,
        boolean isChecked
) {
}
