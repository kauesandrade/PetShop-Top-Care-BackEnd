package com.topcare.petshop.controller.dto.customer;

import com.topcare.petshop.controller.dto.address.CustomerAddressResponseGetDTO;
import com.topcare.petshop.controller.dto.contact.ContactResponseDTO;
import com.topcare.petshop.controller.dto.image.ImageResponseDTO;

import java.time.LocalDate;
import java.util.List;

/**
 * DTO para retornar os dados completos de um cliente ao buscar informações sobre um cliente no sistema de pet shop.
 *
 * Campos:
 * - id: Identificador único do cliente.
 * - profileImage: Imagem de perfil do cliente (ImageResponseDTO).
 * - fullname: Nome completo do cliente.
 * - email: E-mail do cliente.
 * - cpf: CPF do cliente.
 * - birth: Data de nascimento do cliente.
 * - gender: Gênero do cliente.
 * - contactInfo: Lista de informações de contato do cliente (ContactResponseDTO).
 * - addresses: Lista de endereços do cliente (CustomerAddressResponseGetDTO).
 *
 * Anotações:
 * - @param id: ID único do cliente.
 * - @param profileImage: Imagem de perfil do cliente.
 * - @param fullname: Nome completo do cliente.
 * - @param email: E-mail do cliente.
 * - @param cpf: CPF do cliente.
 * - @param birth: Data de nascimento do cliente.
 * - @param gender: Gênero do cliente.
 * - @param contactInfo: Lista de contatos do cliente.
 * - @param addresses: Lista de endereços do cliente.
 */
public record CustomerResponseDTO(Long id, ImageResponseDTO profileImage, String fullname, String email, String cpf,
                                  LocalDate birth, String gender,
                                  List<ContactResponseDTO> contactInfo,
                                  List<CustomerAddressResponseGetDTO> addresses) {
}
