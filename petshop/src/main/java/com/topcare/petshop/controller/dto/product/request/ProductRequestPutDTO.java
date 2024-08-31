package com.topcare.petshop.controller.dto.product.request;

import com.topcare.petshop.controller.dto.product.response.page.ProductSpecificationResponsePageDTO;
import com.topcare.petshop.entity.Brand;
import com.topcare.petshop.entity.ProductCategory;

import java.util.List;

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
        String title,
        String description,
        String shortDescription,
        Long idBrand,
        List<Long> idsCategories,
        List<ProductSpecificationResponsePageDTO> specifications,
        List<ProductVariantRequestPostDTO> variants
) {
}
