package com.topcare.petshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
/**
 * Representa um animal de estimação no sistema.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Cor do pet. Usado como identificador de cor.
     */
    @Enumerated
    @Column(nullable = false)
    private PetColor idColor;

    /**
     * Imagem do pet.
     */
    @OneToOne
    @JoinColumn(nullable = false)
    private PetImage image;

    /**
     * Nome do pet.
     */
    @Column(nullable = false, length = 50)
    private String name;

    /**
     * Tipo do pet (ex: cachorro, gato).
     */
    @ManyToOne
    @JoinColumn(nullable = false)
    private PetType type;

    /**
     * Raça do pet.
     */
    @Column(length = 50)
    private String race;

    /**
     * Tamanho do pet (ex: pequeno, médio, grande).
     */
    @Column(length = 20)
    private String size;

    /**
     * Microchip do pet, deve ser único.
     */
    @Column(unique = true)
    private String microchip;

    /**
     * Gênero do pet.
     */
    @Enumerated
    private PetGender gender;

    /**
     * Cor do pet.
     */
    @Column(length = 30)
    private String color;

    /**
     * Data de nascimento do pet.
     */
    private LocalDate birth;

    /**
     * Registro Geral do Animal (RGA), deve ser único.
     */
    @Column(unique = true)
    private String rga;

    /**
     * Peso do pet em quilos.
     */
    private Double weight;

    /**
     * Lista de agendamentos associados ao pet.
     */
    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Schedule> schedules;
}
