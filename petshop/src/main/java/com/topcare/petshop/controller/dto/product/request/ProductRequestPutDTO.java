package com.topcare.petshop.controller.dto.product.request;

/**
 * DTO para enviar os dados de atualização de um produto no sistema de pet shop.
 *
 * Campos:
 * - productCode: Código do produto a ser atualizado.
 * - productRequestPostDTO: Dados atualizados do produto (ProductRequestPostDTO).
 *
 * Anotações:
 * - @param productCode: Código único do produto a ser atualizado.
 * - @param productRequestPostDTO: Dados atualizados do produto.
 */
public record ProductRequestPutDTO(
        Long productCode,
        ProductRequestPostDTO productRequestPostDTO
) {
}
