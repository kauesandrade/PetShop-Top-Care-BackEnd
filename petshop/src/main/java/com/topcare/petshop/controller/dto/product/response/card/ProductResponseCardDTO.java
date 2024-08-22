package com.topcare.petshop.controller.dto.product.response.card;

import com.topcare.petshop.controller.dto.brand.BrandResponseDTO;
import com.topcare.petshop.entity.ProductImage;

/**
 * DTO para retornar informações resumidas sobre um produto em um cartão de exibição.
 *
 * Campos:
 * - code: Código do produto.
 * - variantCode: Código da variante do produto.
 * - title: Título do produto.
 * - brand: Informações da marca do produto (BrandResponseDTO).
 * - price: Preço da variante do produto.
 * - discountPrice: Preço com desconto da variante do produto.
 * - parcels: Número de parcelas disponíveis para pagamento.
 * - rating: Avaliação do produto.
 * - image: Imagem associada à variante do produto (ProductImage).
 *
 * Anotações:
 * - @param code: Código único do produto.
 * - @param variantCode: Código da variante do produto.
 * - @param title: Título do produto.
 * - @param brand: Informações da marca associada ao produto.
 * - @param price: Preço da variante do produto.
 * - @param discountPrice: Preço da variante do produto com desconto.
 * - @param parcels: Número de parcelas para pagamento.
 * - @param rating: Avaliação média do produto.
 * - @param image: Imagem da variante do produto.
 */
public record ProductResponseCardDTO(
        Long code,
        Long variantCode,
        String title,
        BrandResponseDTO brand,
        Double price,
        Double discountPrice,
        Integer parcels,
        Double rating,
        ProductImage image
) {
}
