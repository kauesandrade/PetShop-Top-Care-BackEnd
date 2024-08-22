package com.topcare.petshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.topcare.petshop.controller.dto.productReview.ProductReviewGetDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    public ProductReviewGetDTO toDto(){
        return new ProductReviewGetDTO(
                this.customer.toProductReviewDto(),
                this.review,
                this.rating,
                this.creationDate
        );
    }
}
