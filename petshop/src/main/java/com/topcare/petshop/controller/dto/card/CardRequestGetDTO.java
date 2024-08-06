package com.topcare.petshop.controller.dto.card;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public record CardRequestGetDTO(String name, String lastDigits, LocalDate expirationDate, Boolean mainCard) {
}
