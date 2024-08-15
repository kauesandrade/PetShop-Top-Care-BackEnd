package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.contact.ContactRequestPostDTO;
import com.topcare.petshop.controller.dto.contact.ContactRequestPutDTO;
import com.topcare.petshop.controller.dto.contact.ContactResponseDTO;
import jakarta.persistence.*;
import lombok.*;

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

    public Contact(ContactRequestPostDTO contactDTO) {
        this.setCellphone(contactDTO.cellphone());
        this.setTelephone(contactDTO.telephone());
    }

    public Contact(ContactRequestPutDTO contactDTO) {
        this.setId(contactDTO.id());
        this.setCellphone(contactDTO.cellphone());
        this.setTelephone(contactDTO.telephone());
    }

    public ContactResponseDTO toDTO() {
        return new ContactResponseDTO(this.id, this.cellphone, this.telephone);
    }

}
