package com.topcare.petshop.controller.dto.product.response.page;

import com.topcare.petshop.entity.ProductImage;

import java.util.List;

/**
 * DTO para retornar informações detalhadas sobre uma variante de produto em uma página.
 *
 * Campos:
 * - variantTitle: Título da variante do produto.
 * - variantCode: Código da variante do produto.
 * - price: Preço da variante do produto.
 * - discountPrice: Preço com desconto da variante do produto.
 * - parcels: Número de parcelas disponíveis para pagamento.
 * - stock: Disponibilidade em estoque da variante do produto.
 * - images: Lista de imagens associadas à variante do produto (ProductImage).
 *
 * Anotações:
 * - @param variantTitle: Título da variante do produto.
 * - @param variantCode: Código único da variante do produto.
 * - @param price: Preço da variante do produto.
 * - @param discountPrice: Preço da variante com desconto.
 * - @param parcels: Número de parcelas para pagamento.
 * - @param stock: Disponibilidade da variante em estoque.
 * - @param images: Lista de imagens da variante do produto.
 */
public record ProductVariantResponsePageDTO(
        String variantTitle,
        Long variantCode,
        Double price,
        Double discountPrice,
        Integer parcels,
        Boolean stock,
        List<ProductImage> images
) {
}
