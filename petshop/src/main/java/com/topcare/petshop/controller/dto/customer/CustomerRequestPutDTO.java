package com.topcare.petshop.controller.dto.customer;

import com.topcare.petshop.controller.dto.address.CustomerAddressRequestPostDTO;
import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import com.topcare.petshop.entity.Gender;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public record CustomerRequestPutDTO(MultipartFile profileImage, String fullname, String email, String cpf, LocalDate birth,
                                    Gender gender) {
}
