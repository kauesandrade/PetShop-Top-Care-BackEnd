package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.address.CustomerAddressResponseGetDTO;
import jakarta.persistence.*;
import lombok.*;

/**
 * Entidade base para endereços.
 * Define os atributos comuns de um endereço e suas operações básicas.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    @NonNull
    private String name;

    @Column(nullable = false, length = 8)
    @NonNull
    private String cep;

    @Column(nullable = false)
    @NonNull
    @Enumerated
    private State state;

    @Column(nullable = false, length = 40)
    @NonNull
    private String city;

    @Column(nullable = false, length = 50)
    @NonNull
    private String neighborhood;

    @Column(nullable = false, length = 50)
    @NonNull
    private String street;

    @Column(nullable = false, length = 5)
    @NonNull
    private String number;

    @Column(length = 150)
    @NonNull
    private String complement;

    /**
     * Converte a entidade para um DTO (Data Transfer Object).
     *
     * @return DTO com os dados do endereço.
     */
    public CustomerAddressResponseGetDTO toDTO() {
        return new CustomerAddressResponseGetDTO(name, cep, state, city, neighborhood,
                street, number, complement);
    }
}
