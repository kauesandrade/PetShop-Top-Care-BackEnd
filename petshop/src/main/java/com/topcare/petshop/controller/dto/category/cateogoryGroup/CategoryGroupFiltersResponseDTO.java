package com.topcare.petshop.controller.dto.category.cateogoryGroup;

import com.topcare.petshop.controller.dto.category.ProductCategoryResponseDTO;

import java.util.List;

/**
 * DTO para retornar os filtros de um grupo de categorias, incluindo o título
 * e uma lista de categorias de produtos associadas.
 *
 * Campos:
 * - title: Título do grupo de categorias.
 * - categories: Lista de categorias de produtos associadas a este grupo.
 *
 * Anotações:
 * - @param title: O título do grupo de categorias.
 * - @param categories: Lista de categorias de produtos (ProductCategoryResponseDTO) no grupo.
 */
public record CategoryGroupFiltersResponseDTO(
        String title,
        List<ProductCategoryResponseDTO> categories
) {
}
