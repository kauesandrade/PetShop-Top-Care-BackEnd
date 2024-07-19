package com.topcare.petshop.controller.dto.contact;

public record ContactRequestPostDTO(
        String cellphone,
        String telephone

) {
    public boolean getCellphone() {
        return false;
    }

    public boolean getTelephone() {
        return false;
    }
}
