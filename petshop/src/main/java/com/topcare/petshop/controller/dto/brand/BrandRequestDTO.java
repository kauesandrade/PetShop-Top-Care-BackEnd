package com.topcare.petshop.controller.dto.brand;

import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import org.springframework.web.multipart.MultipartFile;

/**
 * A classe BrandRequestDTO é um DTO (Data Transfer Object) utilizado para enviar
 * os dados de uma marca (Brand) ao criar ou atualizar uma marca no sistema de pet shop.
 *
 * Campos:
 * - name: Nome da marca. Este campo é obrigatório para identificar a marca no sistema.
 * - image: Um arquivo de imagem associado à marca, utilizado para representar visualmente a marca.
 *
 * Anotações:
 * - @param name: O nome da marca.
 * - @param image: O arquivo de imagem da marca (do tipo MultipartFile).
 */
public record BrandRequestDTO(String name, MultipartFile image) {
}
