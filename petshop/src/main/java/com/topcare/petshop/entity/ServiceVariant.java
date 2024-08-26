package com.topcare.petshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

/**
 * A classe ServiceVariant representa uma variante de um serviço oferecido pelo petshop.
 * Cada variante possui um código único, título, preço e tempo estimado para execução.
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
public class ServiceVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Long variantCode;

    @Column(nullable = false, length = 60)
    private String variantTitle;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private LocalTime estimatedTime;

}
