package com.topcare.petshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * A classe Service representa um serviço oferecido por um petshop.
 * Cada serviço possui um código único, uma imagem, título, descrição, categoria,
 * lista de tipos de pets que podem ser atendidos e uma lista de variantes do serviço.
 *
 * Anotações:
 * - @Entity: Define que a classe será mapeada para uma tabela no banco de dados.
 * - @Data: Gera automaticamente getters, setters, equals, hashCode e toString.
 * - @AllArgsConstructor e @NoArgsConstructor: Gera os construtores com e sem argumentos.
 * - @Id e @GeneratedValue: Define o identificador único da entidade com geração automática de ID.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Long code;

    @OneToOne
    @JoinColumn(name = "image_id", nullable = false)
    private ServiceImage image;

    @Column(nullable = false, length = 35)
    private String title;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(nullable = false)
    private ServiceCategory category;

    @ManyToMany
    private List<PetType> servedPets;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_id")
    private List<ServiceVariant> variants;

}
