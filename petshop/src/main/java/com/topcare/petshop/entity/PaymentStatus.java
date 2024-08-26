package com.topcare.petshop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
/**
 * Enumeração que representa os possíveis status de pagamento.
 */
@AllArgsConstructor
@Getter
public enum PaymentStatus {

    IN_PROCESS("Em processo"),
    CANCELED("Cancelado"),
    APPROVED("Aprovado");

    private final String status;
}
