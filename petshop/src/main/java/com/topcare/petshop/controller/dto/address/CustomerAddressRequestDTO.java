package com.topcare.petshop.controller.dto.address;

/**
 * DTO (Data Transfer Object) utilizado para receber os dados de um endereço
 * ao criar ou atualizar um cliente no sistema de pet shop.
 *
 * @param name O nome do cliente.
 * @param cep O CEP (Código de Endereçamento Postal) do endereço do cliente.
 * @param state O estado (UF) do endereço do cliente.
 * @param city A cidade do endereço do cliente.
 * @param neighborhood O bairro do endereço do cliente.
 * @param street A rua do endereço do cliente.
 * @param number O número do imóvel no endereço do cliente.
 * @param complement Complemento do endereço (ex: apartamento, bloco).
 */
public record CustomerAddressRequestDTO(String name, String cep, String state, String city, String neighborhood,
                                        String street, String number, String complement) {
}
