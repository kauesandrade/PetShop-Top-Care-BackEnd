package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.card.CardRequestDTO;
import com.topcare.petshop.controller.dto.card.CardResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Entidade para cartões de pagamento.
 * Armazena informações de cartões associados a um cliente.
 */
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

    /**
     * Construtor que inicializa a entidade com base em um DTO de solicitação de cartão.
     *
     * @param dto DTO com os dados do cartão.
     */
    public Card(CardRequestDTO dto) {
        this.name = dto.name();
        this.lastDigits = dto.lastDigits();
        this.expirationDate = LocalDate.parse(dto.expirationDate());
        this.mainCard = dto.mainCard();
        this.customer = new Customer(dto.userId());
    }

    /**
     * Converte a entidade para um DTO (Data Transfer Object).
     *
     * @return DTO com os dados do cartão.
     */
    public CardResponseDTO toDTO() {
        return new CardResponseDTO(this.id, this.name, this.lastDigits, this.expirationDate, this.mainCard);
    }

    /**
     * Atualiza os dados do cartão com base em um DTO de solicitação de cartão.
     *
     * @param dto DTO com os dados atualizados do cartão.
     */
    public void edit(CardRequestDTO dto) {
        this.name = dto.name();
        this.lastDigits = dto.lastDigits();
        this.expirationDate = LocalDate.parse(dto.expirationDate());
        this.mainCard = dto.mainCard();
        this.customer = new Customer(dto.userId());
    }
}
