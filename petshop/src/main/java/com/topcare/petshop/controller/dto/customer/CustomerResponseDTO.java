package com.topcare.petshop.controller.dto.customer;

import com.topcare.petshop.controller.dto.address.CustomerAddressResponseGetDTO;
import com.topcare.petshop.controller.dto.contact.ContactResponseDTO;
import com.topcare.petshop.controller.dto.image.ImageResponseDTO;

import java.time.LocalDate;
import java.util.List;

public record CustomerResponseDTO(Long id, ImageResponseDTO profileImage, String fullname, String email, String cpf,
                                  LocalDate birth, String gender,
                                  List<ContactResponseDTO> contactInfo,
                                  List<CustomerAddressResponseGetDTO> addresses) {
}
