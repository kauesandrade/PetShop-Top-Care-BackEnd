package com.topcare.petshop.controller.dto.customer;

import com.topcare.petshop.controller.dto.address.CustomerAddressRequestDTO;

public record CustomerRequestPostDTO(String fullname, String email, String cellphone, String telephone,
                                     String cpf, String gender, String birth, String password,
                                     CustomerAddressRequestDTO address) {
}
