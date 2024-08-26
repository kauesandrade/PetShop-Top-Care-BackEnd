package com.topcare.petshop.controller.dto.category.cateogoryGroup;

import com.topcare.petshop.entity.CategoryImage;
import com.topcare.petshop.entity.ProductCategory;

import java.util.List;

/**
 * DTO para enviar os dados de um grupo de categorias ao criar ou atualizar um grupo
 * de categorias no sistema de pet shop.
 *
 * Campos:
 * - title: Título do grupo de categorias.
 * - categories: Lista de categorias de produtos associadas ao grupo.
 * - image: Imagem associada ao grupo de categorias.
 *
 * Anotações:
 * - @param title: O título do grupo de categorias.
 * - @param categories: Lista de categorias de produtos (ProductCategory) no grupo.
 * - @param image: Imagem do grupo de categorias (CategoryImage).
 */
public record CategoryGroupRequestDTO(
        String title,
        List<ProductCategory> categories,
        CategoryImage image
) {
}
