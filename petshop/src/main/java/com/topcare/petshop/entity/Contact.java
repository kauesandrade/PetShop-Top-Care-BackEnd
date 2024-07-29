package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.contact.ContactRequestGetDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 11)
    private String cellphone;

    @Column(length = 11)
    private String telephone;

    public ContactRequestGetDTO toDTO() {
        return new ContactRequestGetDTO(this.cellphone, this.telephone);
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
}
