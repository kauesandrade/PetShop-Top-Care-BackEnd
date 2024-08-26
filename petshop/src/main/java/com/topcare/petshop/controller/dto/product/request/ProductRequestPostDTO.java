package com.topcare.petshop.controller.dto.product.request;

import com.topcare.petshop.controller.dto.product.response.page.ProductSpecificationResponsePageDTO;
import com.topcare.petshop.entity.Brand;
import com.topcare.petshop.entity.ProductCategory;

import java.util.List;

/**
 * DTO para enviar os dados ao criar um novo produto no sistema de pet shop.
 *
 * Campos:
 * - title: Título do produto.
 * - code: Código do produto.
 * - description: Descrição completa do produto.
 * - shortDescription: Descrição resumida do produto.
 * - brand: Marca do produto (Brand).
 * - categories: Lista de categorias do produto (ProductCategory).
 * - specifications: Lista de especificações do produto (ProductSpecificationResponsePageDTO).
 * - variants: Lista de variantes do produto (ProductVariantRequestPostDTO).
 *
 * Anotações:
 * - @param title: Título do produto.
 * - @param code: Código único do produto.
 * - @param description: Descrição detalhada do produto.
 * - @param shortDescription: Descrição resumida do produto.
 * - @param brand: Marca do produto.
 * - @param categories: Lista de categorias associadas ao produto.
 * - @param specifications: Lista de especificações do produto.
 * - @param variants: Lista de variantes do produto.
 */
public record ProductRequestPostDTO(

        String title,
        Long code,
        String description,
        String shortDescription,
        Brand brand,
        List<ProductCategory> categories,
        List<ProductSpecificationResponsePageDTO> specifications,
        List<ProductVariantRequestPostDTO> variants

) {
}
