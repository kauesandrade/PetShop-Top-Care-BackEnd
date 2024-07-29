package com.topcare.petshop.controller.dto.contact;

public record ContactRequestPutDTO(
        Long id,
        String cellphone,
        String telephone
) {
}
