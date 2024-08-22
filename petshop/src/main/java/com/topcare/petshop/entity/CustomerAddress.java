package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.address.CustomerAddressRequestDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
/**
 * Representa um endereço de um cliente.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class CustomerAddress extends Address {

    /**
     * Constrói um CustomerAddress a partir de um DTO de solicitação de endereço.
     *
     * @param address DTO de solicitação de endereço.
     */
    public CustomerAddress(CustomerAddressRequestDTO address) {
        super(address.name(), address.cep(), State.valueOf(address.state()), address.city(),
                address.neighborhood(), address.street(), address.number(), address.complement());
    }
}

