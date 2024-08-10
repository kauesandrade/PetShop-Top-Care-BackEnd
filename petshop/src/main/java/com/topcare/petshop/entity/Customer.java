package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.contact.ContactResponseGetDTO;
import com.topcare.petshop.controller.dto.address.CustomerAddressResponseGetDTO;
import com.topcare.petshop.controller.dto.customer.CustomerRequestPostDTO;
import com.topcare.petshop.controller.dto.customer.CustomerRequestPutDTO;
import com.topcare.petshop.controller.dto.customer.CustomerResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends User {

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private CustomerImage profileImage;

    @Column(nullable = false)
    private LocalDate birth;

    @Column(nullable = false)
    @Enumerated
    private Gender gender;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "customer_id", nullable = false)
    private List<Contact> contactInfo;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "customer_id", nullable = false)
    private List<CustomerAddress> addresses;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "customer")
    private List<Card> cards;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "customer_id")
    private List<CustomerOrder> orders;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "customer_id")
    private List<Pet> pets;

    @ManyToMany
    private List<ProductVariant> favorites;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Cart cart;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "customer")
    private List<ProductReview> reviews;

    public Customer(Long id) {
        super(id);
    }

    public Customer(CustomerRequestPostDTO customer) {
        super(customer.fullname(), customer.email(), customer.password(), customer.cpf(), UserRole.CUSTOMER);

        this.setContactInfo(List.of(new Contact(customer.cellphone(), customer.telephone())));
        this.setGender(Gender.defineGender(customer.gender()));
        this.setBirth(LocalDate.parse(customer.birth()));
        this.setAddresses(List.of(new CustomerAddress(customer.address())));

        // tem q fzr p iniciar com image
        this.setProfileImage(new CustomerImage("topcare".getBytes()));
        this.setCards(List.of());
        this.setOrders(List.of());
        this.setPets(List.of());
        this.setFavorites(List.of());
        this.setCart(new Cart());
    }

    public CustomerResponseDTO toDTO() {
        List<ContactResponseGetDTO> contacts = this.getContactInfo().stream().map(Contact::toDTO).toList();
        List<CustomerAddressResponseGetDTO> addresses = this.getAddresses().stream().map(Address::toDTO).toList();

        return new CustomerResponseDTO(
                this.getId(),
                this.getProfileImage().toDTO(),
                this.getFullname(),
                this.getEmail(),
                this.getCpf(),
                this.getBirth(),
                this.getGender().getGender(),
                contacts,
                addresses
        );
    }

    public void edit(CustomerRequestPutDTO customerDTO) throws IOException {
        this.setProfileImage(new CustomerImage(customerDTO.profileImage()));
        this.setFullname(customerDTO.fullname());
        this.setEmail(customerDTO.email());
        this.setCpf(customerDTO.cpf());
        this.setBirth(customerDTO.birth());
        this.setGender(customerDTO.gender());
    }
}
