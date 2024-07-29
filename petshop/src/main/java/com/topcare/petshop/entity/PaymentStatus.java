package com.topcare.petshop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PaymentStatus {
    IN_PROCESS("Em processo"),
    CANCELED("Cancelado"),
    APPROVED("Aprovado");

    private String status;
}
