package com.topcare.petshop.controller.dto.customer;

import com.topcare.petshop.controller.dto.address.AddressRequestDTO;

/**
 * DTO para enviar os dados de um novo cliente ao criar um cliente no sistema de pet shop.
 *
 * Campos:
 * - fullname: Nome completo do cliente.
 * - email: E-mail do cliente.
 * - cellphone: Número de celular do cliente.
 * - telephone: Número de telefone do cliente.
 * - cpf: CPF do cliente.
 * - gender: Gênero do cliente.
 * - birth: Data de nascimento do cliente.
 * - password: Senha do cliente.
 * - address: Endereço do cliente (CustomerAddressRequestDTO).
 *
 * Anotações:
 * - @param fullname: Nome completo do cliente.
 * - @param email: E-mail do cliente.
 * - @param cellphone: Número de celular do cliente.
 * - @param telephone: Número de telefone do cliente.
 * - @param cpf: CPF do cliente.
 * - @param gender: Gênero do cliente.
 * - @param birth: Data de nascimento do cliente.
 * - @param password: Senha do cliente.
 * - @param address: Endereço do cliente (CustomerAddressRequestDTO).
 */
public record CustomerRequestPostDTO(String fullname, String email, String cellphone, String telephone,
                                     String cpf, String gender, String birth, String password,
                                     AddressRequestDTO address) {
}
