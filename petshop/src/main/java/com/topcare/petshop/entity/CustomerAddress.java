package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.address.CustomerAddressRequestPostDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class CustomerAddress extends Address {

    public CustomerAddress(CustomerAddressRequestPostDTO address) {
        super(address.name(), address.cep(),  State.valueOf(address.state()), address.city(),
                address.neighborhood(), address.street(), address.number(), address.complement());
    }

}
