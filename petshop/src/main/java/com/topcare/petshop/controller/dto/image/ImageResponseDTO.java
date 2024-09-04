package com.topcare.petshop.controller.dto.image;

import java.io.InputStream;

/**
 * DTO para retornar as informações de uma imagem após o upload.
 *
 * Campos:
 * - name: Nome do arquivo da imagem.
 * - type: Tipo do arquivo da imagem (por exemplo, "image/jpeg").
 * - size: Tamanho do arquivo da imagem em bytes.
 * - url: URL onde a imagem está disponível.
 *
 * Anotações:
 * - @param name: Nome do arquivo da imagem.
 * - @param type: Tipo do arquivo da imagem.
 * - @param size: Tamanho do arquivo da imagem em bytes.
 * - @param url: URL onde a imagem está acessível.
 */
public record ImageResponseDTO(
        String name,
        String type,
        Long size,
        String url
) {
}
