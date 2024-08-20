package com.topcare.petshop.controller.dto.address;

public record CustomerAddressRequestDTO(String name, String cep, String state, String city, String neighborhood,
                                        String street, String number, String complement) {
}
