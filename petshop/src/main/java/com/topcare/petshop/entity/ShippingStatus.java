package com.topcare.petshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * A classe ShippingStatus representa o status de uma entrega em um determinado momento.
 * Cada status possui um valor, data/hora de criação e está relacionado a uma entrega específica.
 *
 * Anotações:
 * - @Entity: Define que a classe será mapeada para uma tabela no banco de dados.
 * - @Data: Gera automaticamente getters, setters, equals, hashCode e toString.
 * - @AllArgsConstructor e @NoArgsConstructor: Gera os construtores com e sem argumentos.
 * - @Id e @GeneratedValue: Define o identificador único da entidade com geração automática de ID.
 * - @CreationTimestamp: Gera automaticamente o timestamp na criação da entidade.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    @Column(nullable = false)
    private DeliveryStatus value;

    @CreationTimestamp
    private LocalDateTime dateTime;

}