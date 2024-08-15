package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.contact.ContactDTO;
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

    public ContactDTO toDTO() {
        return new ContactDTO(this.cellphone, this.telephone);
    }

}
