package com.topcare.petshop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
/**
 * Enumeração que representa os possíveis status de entrega de um pedido.
 */
@AllArgsConstructor
@Getter
public enum DeliveryStatus {

    ORDER("Pedido"),
    SENT_TO_COMPANY("Enviado para transportadora"),
    COMPANY_RECEIVED("Recebido pela transportadora"),
    IN_TRANSIT("Mercadoria em trânsito"),
    ON_DELIVERY_ROUTE("Mercadoria em rota de entrega"),
    DELIVERED("Pedido entregue");

    private final String status;
}
