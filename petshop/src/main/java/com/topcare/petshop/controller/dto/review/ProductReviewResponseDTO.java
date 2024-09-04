package com.topcare.petshop.controller.dto.review;

import com.topcare.petshop.controller.dto.customer.CustomerResponseReviewDTO;

import java.time.LocalDate;

/**
 * DTO para retornar uma avaliação de produto com detalhes do cliente.
 *
 * Campos:
 * - customer: Informações sobre o cliente que fez a avaliação (CustomerResponseReviewDTO).
 * - review: Texto da avaliação do produto.
 * - rating: Avaliação em números (geralmente em uma escala de 1 a 5).
 * - reviewDate: Data em que a avaliação foi realizada.
 *
 * Anotações:
 * - @param customer: Informações do cliente que escreveu a avaliação.
 * - @param review: Texto da avaliação do produto.
 * - @param rating: Nota dada ao produto na avaliação.
 * - @param reviewDate: Data em que a avaliação foi escrita.
 */
public record ProductReviewResponseDTO(
        CustomerResponseReviewDTO customer,
        String review,
        Integer rating,
        LocalDate reviewDate
) {
}
