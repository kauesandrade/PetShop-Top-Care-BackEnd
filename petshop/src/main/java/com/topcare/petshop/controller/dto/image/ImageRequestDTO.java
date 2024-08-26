package com.topcare.petshop.controller.dto.image;

import org.springframework.web.multipart.MultipartFile;

/**
 * DTO para enviar uma solicitação de upload de imagem.
 *
 * Campos:
 * - file: Arquivo de imagem a ser enviado (MultipartFile).
 *
 * Anotações:
 * - @param file: Arquivo de imagem a ser carregado. Representado como MultipartFile.
 */
public record ImageRequestDTO(
        MultipartFile file
) {
}
