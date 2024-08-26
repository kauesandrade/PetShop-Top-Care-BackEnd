package com.topcare.petshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * A classe Schedule representa o agendamento de um serviço para um pet em um petshop.
 * Cada agendamento possui um pet, um cliente, um petshop, um pagamento, uma data/hora
 * e uma lista de serviços relacionados.
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
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Pet pet;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Petshop petshop;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Payment payment;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @ManyToMany
    private List<ServiceVariant> services;

}
