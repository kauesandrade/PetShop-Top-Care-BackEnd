package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.card.CardRequestGetPostDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 4)
    private String lastDigits;

    @Column(nullable = false)
    private LocalDate expirationDate;

    @Column(nullable = false)
    private Boolean mainCard;

    public CardRequestGetPostDTO toDto(){
        return new CardRequestGetPostDTO(
                this.name,
                this.lastDigits,
                this.expirationDate,
                this.mainCard
        );
    }
}
