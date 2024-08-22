package com.topcare.petshop.controller.dto.category.cateogoryGroup;

import com.topcare.petshop.controller.dto.category.ProductCategoryResponseDTO;
import com.topcare.petshop.entity.CategoryImage;

import java.util.List;

/**
 * DTO para retornar os dados de um grupo de categorias, incluindo o ID, título,
 * lista de categorias de produtos associadas e imagem do grupo.
 *
 * Campos:
 * - id: Identificador único do grupo de categorias.
 * - title: Título do grupo de categorias.
 * - categories: Lista de categorias de produtos (ProductCategoryResponseDTO) no grupo.
 * - image: Imagem associada ao grupo de categorias (CategoryImage).
 *
 * Anotações:
 * - @param id: ID único do grupo de categorias.
 * - @param title: O título do grupo de categorias.
 * - @param categories: Lista de categorias de produtos (ProductCategoryResponseDTO) no grupo.
 * - @param image: Imagem do grupo de categorias (CategoryImage).
 */
public record CategoryGroupResponseDTO(
        Long id,
        String title,
        List<ProductCategoryResponseDTO> categories,
        CategoryImage image
) {
}
