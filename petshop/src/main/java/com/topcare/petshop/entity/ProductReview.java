package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.review.ProductReviewResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
/**
 * Representa uma avaliação de um produto por um cliente.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Cliente que fez a avaliação.
     */
    @ManyToOne
    private Customer customer;

    /**
     * Texto da avaliação.
     */
    private String review;

    /**
     * Classificação dada pelo cliente.
     */
    @Column(nullable = false)
    private Integer rating;

    /**
     * Data em que a avaliação foi criada.
     */
    @CreationTimestamp
    private LocalDate creationDate;

    /**
     * Converte a avaliação para um DTO.
     *
     * @return DTO da avaliação.
     */
    public ProductReviewResponseDTO toDTO() {
        return new ProductReviewResponseDTO(
                getCustomer().toReviewDTO(),
                getReview(),
                getRating(),
                getCreationDate()
        );
    }
}
