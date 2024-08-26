package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.contact.ContactRequestPostDTO;
import com.topcare.petshop.controller.dto.contact.ContactRequestPutDTO;
import com.topcare.petshop.controller.dto.contact.ContactResponseDTO;
import jakarta.persistence.*;
import lombok.*;
/**
 * Representa um contato associado a um cliente.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 11)
    private String cellphone;

    @Column(length = 11)
    private String telephone;

    /**
     * Constrói um Contact a partir de um DTO de solicitação para criação.
     *
     * @param contactDTO DTO de solicitação para criação de contato.
     */
    public Contact(ContactRequestPostDTO contactDTO) {
        this.setCellphone(contactDTO.cellphone());
        this.setTelephone(contactDTO.telephone());
    }

    /**
     * Constrói um Contact a partir de um DTO de solicitação para atualização.
     *
     * @param contactDTO DTO de solicitação para atualização de contato.
     */
    public Contact(ContactRequestPutDTO contactDTO) {
        this.setId(contactDTO.id());
        this.setCellphone(contactDTO.cellphone());
        this.setTelephone(contactDTO.telephone());
    }

    /**
     * Converte o Contact para um DTO de resposta.
     *
     * @return DTO de resposta do contato.
     */
    public ContactResponseDTO toDTO() {
        return new ContactResponseDTO(this.id, this.cellphone, this.telephone);
    }

    /**
     * Atualiza o Contact com base em um DTO de solicitação para atualização.
     *
     * @param contactDTO DTO de solicitação para atualização de contato.
     */
    public void edit(ContactRequestPutDTO contactDTO) {
        this.setCellphone(contactDTO.cellphone());
        this.setTelephone(contactDTO.telephone());
    }
}
