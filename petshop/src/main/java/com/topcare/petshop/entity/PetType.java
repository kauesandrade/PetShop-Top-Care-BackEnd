package com.topcare.petshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Representa um tipo de pet (ex: cachorro, gato).
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome do tipo de pet.
     */
    @Column(nullable = false, length = 15)
    private String type;
}
