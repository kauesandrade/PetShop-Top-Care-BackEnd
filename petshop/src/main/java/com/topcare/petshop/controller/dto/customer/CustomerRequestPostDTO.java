package com.topcare.petshop.controller.dto.customer;

import com.topcare.petshop.controller.dto.address.CustomerAddressRequestPostDTO;
import com.topcare.petshop.entity.Gender;

import java.time.LocalDate;

public record CustomerRequestPostDTO(String fullname, String email, String cellphone, String telephone,
                                     String cpf, String gender, String birth, String password,
                                     CustomerAddressRequestPostDTO address) {
}
