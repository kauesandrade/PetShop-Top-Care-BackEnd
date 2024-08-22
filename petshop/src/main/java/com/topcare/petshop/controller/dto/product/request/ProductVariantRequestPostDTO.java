package com.topcare.petshop.controller.dto.product.request;

import com.topcare.petshop.entity.ProductImage;

import java.util.List;

/**
 * DTO para enviar os dados de uma variante de produto ao criar ou atualizar uma variante no sistema de pet shop.
 *
 * Campos:
 * - variantTitle: Título da variante do produto.
 * - variantCode: Código da variante do produto.
 * - price: Preço da variante do produto.
 * - amountStock: Quantidade em estoque da variante do produto.
 * - discount: Desconto aplicado na variante do produto.
 *
 * Anotações:
 * - @param variantTitle: Título da variante do produto.
 * - @param variantCode: Código único da variante do produto.
 * - @param price: Preço da variante do produto.
 * - @param amountStock: Quantidade em estoque da variante do produto.
 * - @param discount: Desconto aplicado na variante do produto.
 * - @param images: Lista de imagens da variante do produto (comentado no momento).
 */
public record ProductVariantRequestPostDTO(
        String variantTitle,
        Long variantCode,
        Double price,
        Integer amountStock,
        Double discount
        // List<ProductImage> images
) {
}
