package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.address.AddressRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
/**
 * Representa o endereço de um petshop.
 * Herda de {@link Address}.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class PetshopAddress extends Address {
    public PetshopAddress(AddressRequestDTO address) {
        super(address.name(), address.cep(), State.valueOf(address.state()), address.city(), address.neighborhood(), address.street(), address.number(), address.complement());
    }
}
