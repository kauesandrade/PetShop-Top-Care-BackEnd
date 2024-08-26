package com.topcare.petshop.controller.dto.customer;

import com.topcare.petshop.controller.dto.contact.ContactRequestPutDTO;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

/**
 * DTO para enviar os dados de um cliente ao atualizar as informações de um cliente no sistema de pet shop,
 * mas sem incluir a imagem de perfil.
 *
 * Campos:
 * - profileImage: Imagem de perfil do cliente (MultipartFile).
 * - fullname: Nome completo do cliente.
 * - email: E-mail do cliente.
 * - cpf: CPF do cliente.
 * - birth: Data de nascimento do cliente.
 * - gender: Gênero do cliente.
 * - contacts: Lista de contatos do cliente (ContactRequestPutDTO).
 *
 * Anotações:
 * - @param profileImage: Imagem de perfil do cliente.
 * - @param fullname: Nome completo do cliente.
 * - @param email: E-mail do cliente.
 * - @param cpf: CPF do cliente.
 * - @param birth: Data de nascimento do cliente.
 * - @param gender: Gênero do cliente.
 * - @param contacts: Lista de contatos do cliente (ContactRequestPutDTO).
 */
public record CustomerWoImageRequestPutDTO(MultipartFile profileImage, String fullname, String email, String cpf,
                                           String birth, String gender, List<ContactRequestPutDTO> contacts) {
}
