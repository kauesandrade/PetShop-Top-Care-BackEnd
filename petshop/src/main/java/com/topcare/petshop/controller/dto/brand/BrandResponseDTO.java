package com.topcare.petshop.controller.dto.brand;

import com.topcare.petshop.controller.dto.image.ImageResponseDTO;

/**
 * A classe BrandResponseDTO é um DTO (Data Transfer Object) utilizado para retornar
 * os dados de uma marca (Brand) ao buscar informações da marca no sistema de pet shop.
 *
 * Campos:
 * - name: Nome da marca. Este campo é retornado para identificar a marca.
 * - image: Os dados da imagem associada à marca, incluindo informações como URL e metadados.
 *
 * Anotações:
 * - @param name: O nome da marca.
 * - @param image: Os dados da imagem da marca (do tipo ImageResponseDTO).
 */
public record BrandResponseDTO(
        String name,
        ImageResponseDTO image) {
}
