package com.topcare.petshop.controller.dto.product.response.page;

import com.topcare.petshop.controller.dto.brand.BrandResponseDTO;
import com.topcare.petshop.controller.dto.category.ProductCategoryResponseDTO;
import com.topcare.petshop.controller.dto.review.ProductReviewResponseDTO;

import java.util.List;

/**
 * DTO para retornar informações detalhadas sobre um produto em uma página.
 *
 * Campos:
 * - code: Código do produto.
 * - title: Título do produto.
 * - description: Descrição completa do produto.
 * - shortDescription: Descrição resumida do produto.
 * - brand: Informações da marca do produto (BrandResponseDTO).
 * - specifications: Lista de especificações do produto (ProductSpecificationResponsePageDTO).
 * - rating: Avaliação média do produto.
 * - categories: Lista de categorias associadas ao produto (ProductCategoryResponseDTO).
 * - reviews: Lista de avaliações do produto (ProductReviewResponseDTO).
 * - variants: Lista de variantes do produto (ProductVariantResponsePageDTO).
 *
 * Anotações:
 * - @param code: Código único do produto.
 * - @param title: Título do produto.
 * - @param description: Descrição completa do produto.
 * - @param shortDescription: Descrição resumida do produto.
 * - @param brand: Informações da marca associada ao produto.
 * - @param specifications: Lista de especificações do produto.
 * - @param rating: Avaliação média do produto.
 * - @param categories: Lista de categorias do produto.
 * - @param reviews: Lista de avaliações do produto.
 * - @param variants: Lista de variantes do produto.
 */
public record ProductResponsePageDTO(
        Long code,
        String title,
        String description,
        String shortDescription,
        BrandResponseDTO brand,
        List<ProductSpecificationResponsePageDTO> specifications,
        Double rating,
        List<ProductCategoryResponseDTO> categories,
        List<ProductReviewResponseDTO> reviews,
        List<ProductVariantResponsePageDTO> variants
) {
}
