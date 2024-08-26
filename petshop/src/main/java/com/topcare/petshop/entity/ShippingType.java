package com.topcare.petshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A classe ShippingType representa os tipos de envio disponíveis no petshop.
 *
 * Cada tipo de envio possui informações sobre o tempo estimado de envio, o preço
 * e a duração do envio em minutos.
 *
 * Anotações:
 * - @Entity: Define que a classe será mapeada para uma tabela no banco de dados.
 * - @Data: Gera automaticamente getters, setters, equals, hashCode e toString.
 * - @AllArgsConstructor: Gera um construtor com todos os atributos da classe.
 * - @NoArgsConstructor: Gera um construtor sem argumentos.
 * - @Id e @GeneratedValue: Define o identificador único da entidade com geração automática de ID.
 * - @Column: Configura as propriedades das colunas no banco de dados.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String shippingTime; /** Tempo estimado para o envio (Ex: "Expresso", "Normal")*/

    private Integer time; /**Tempo de entrega em minutos*/

    private Double price; /** Preço do envio*/

}
