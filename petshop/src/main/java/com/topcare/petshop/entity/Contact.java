package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.contact.ContactResponseGetDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 11)
    @NonNull
    private String cellphone;

    @Column(length = 11)
    @NonNull
    private String telephone;

    public ContactResponseGetDTO toDTO() {
        return new ContactResponseGetDTO(this.cellphone, this.telephone);
    }

}
