package com.topcare.petshop.controller.dto.address;

import com.topcare.petshop.entity.State;

public record CustomerAddressResponseGetDTO(String name, String cep, State state, String city, String neighborhood,
                                            String street, String number, String complement) {
}
