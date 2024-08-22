package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.card.CardRequestDTO;
import com.topcare.petshop.controller.dto.card.CardResponseDTO;
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

    @ManyToOne
    private Customer customer;

    public Card(CardRequestDTO dto) {
        this.name = dto.name();
        this.lastDigits = dto.lastDigits();
        this.expirationDate = LocalDate.parse(dto.expirationDate());
        this.mainCard = dto.mainCard();
        this.customer = new Customer(dto.userId());
    }

    public CardResponseDTO toDTO() {
        return new CardResponseDTO(this.id, this.name, this.lastDigits, this.expirationDate, this.mainCard);
    }

    public void edit(CardRequestDTO dto) {
        this.name = dto.name();
        this.lastDigits = dto.lastDigits();
        this.expirationDate = LocalDate.parse(dto.expirationDate());
        this.mainCard = dto.mainCard();
        this.customer = new Customer(dto.userId());
    }
}
