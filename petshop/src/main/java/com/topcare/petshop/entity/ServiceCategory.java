package com.topcare.petshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * A classe ServiceCategory representa uma categoria de serviços oferecidos pelo petshop.
 * Cada categoria possui um título e uma lista de serviços associados.
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
public class ServiceCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String title;

    @OneToMany(mappedBy = "category")
    private List<Service> services;

}
