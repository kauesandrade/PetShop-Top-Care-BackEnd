package com.topcare.petshop.controller.dto.product.response.searchPage;

import com.topcare.petshop.controller.dto.brand.BrandResponseDTO;
import com.topcare.petshop.controller.dto.category.ProductCategoryResponseDTO;
import com.topcare.petshop.controller.dto.product.response.card.ProductResponseCardDTO;

import java.util.List;

/**
 * DTO para retornar informações sobre produtos em uma página de busca com suporte à paginação.
 *
 * Campos:
 * - productCard: Detalhes do produto em um cartão de exibição (ProductResponseCardDTO).
 * - categories: Lista de categorias associadas ao produto (ProductCategoryResponseDTO).
 *
 * Anotações:
 * - @param productCard: Informações detalhadas do produto em formato de cartão.
 * - @param categories: Lista de categorias relacionadas ao produto.
 */
public record ProductResponseSearchPageableDTO(
        ProductResponseCardDTO productCard,
        List<ProductCategoryResponseDTO> categories
) {
}
