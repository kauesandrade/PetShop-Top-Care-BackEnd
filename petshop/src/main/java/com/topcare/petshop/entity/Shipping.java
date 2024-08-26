package com.topcare.petshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * A classe Shipping representa o envio de produtos ou serviços.
 * Cada envio possui um código de rastreamento, método de envio, tipo de envio e status relacionados.
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
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shippingCode;

    private String shippingBy;

    @ManyToOne
    @JoinColumn(nullable = false)
    private ShippingType shippingType;

    @OneToMany
    private List<ShippingStatus> shippingStatus;

}
