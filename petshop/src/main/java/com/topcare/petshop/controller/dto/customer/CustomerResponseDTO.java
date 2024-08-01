package com.topcare.petshop.controller.dto.customer;

import com.topcare.petshop.controller.dto.address.CustomerAddressResponseGetDTO;
import com.topcare.petshop.controller.dto.contact.ContactResponseGetDTO;

import java.time.LocalDate;
import java.util.List;

public record CustomerResponseDTO(byte[] customer_image, String fullname, String email, String cpf,
                                  LocalDate birth, String gender,
                                  List<ContactResponseGetDTO> contactInfo,
                                  List<CustomerAddressResponseGetDTO> addresses) {
}
