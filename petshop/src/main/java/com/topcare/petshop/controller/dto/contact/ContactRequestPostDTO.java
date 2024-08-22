package com.topcare.petshop.controller.dto.contact;

/**
 * DTO para enviar os dados de contato ao criar um novo contato no sistema de pet shop.
 *
 * Campos:
 * - cellphone: Número de celular do contato.
 * - telephone: Número de telefone do contato.
 *
 * Anotações:
 * - @param cellphone: Número de celular do contato.
 * - @param telephone: Número de telefone do contato.
 */
public record ContactRequestPostDTO(String cellphone, String telephone) {
}
