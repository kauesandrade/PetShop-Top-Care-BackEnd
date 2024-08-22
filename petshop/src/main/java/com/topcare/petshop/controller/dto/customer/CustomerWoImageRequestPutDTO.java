package com.topcare.petshop.controller.dto.customer;

import com.topcare.petshop.controller.dto.contact.ContactRequestPutDTO;
import com.topcare.petshop.entity.Gender;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public record CustomerWoImageRequestPutDTO(MultipartFile profileImage, String fullname, String email, String cpf,
                                           LocalDate birth, Gender gender, List<ContactRequestPutDTO> contacts) {
}
