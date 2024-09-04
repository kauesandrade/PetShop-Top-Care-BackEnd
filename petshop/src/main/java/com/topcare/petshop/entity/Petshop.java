package com.topcare.petshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
/**
 * Representa um petshop.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Petshop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Imagem do petshop.
     */
    @OneToOne
    @JoinColumn(nullable = false)
    private PetshopImage image;

    /**
     * Nome do petshop.
     */
    @Column(nullable = false, length = 50)
    private String name;

    /**
     * Endereço do petshop.
     */
    @OneToOne
    @JoinColumn(nullable = false)
    private PetshopAddress address;

    /**
     * Telefone do petshop.
     */
    @Column(nullable = false, length = 11)
    private String telephone;

   /**
    * Possível adição futura de horário de funcionamento:
    * private OpeningHours openingHours;
    */
}
