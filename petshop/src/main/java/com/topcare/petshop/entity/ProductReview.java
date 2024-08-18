package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.review.ProductReviewResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;

    private String review;

    @Column(nullable = false)
    private Integer rating;

    @CreationTimestamp
    private LocalDate creationDate;

    public ProductReviewResponseDTO toDTO() {
        return  new ProductReviewResponseDTO(
                getCustomer().toReviewDTO(),
                getReview(),
                getRating(),
                getCreationDate()
        );
    }
}
