package com.topcare.petshop.controller.dto.contact;

/**
 * DTO para enviar os dados de contato ao atualizar um contato existente no sistema de pet shop.
 *
 * Campos:
 * - id: Identificador único do contato.
 * - cellphone: Número de celular do contato.
 * - telephone: Número de telefone do contato.
 *
 * Anotações:
 * - @param id: ID único do contato.
 * - @param cellphone: Número de celular do contato.
 * - @param telephone: Número de telefone do contato.
 */
public record ContactRequestPutDTO(Long id, String cellphone, String telephone) {
}
