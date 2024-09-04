package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.address.CustomerAddressResponseGetDTO;
import com.topcare.petshop.controller.dto.contact.ContactRequestPutDTO;
import com.topcare.petshop.controller.dto.contact.ContactResponseDTO;
import com.topcare.petshop.controller.dto.customer.CustomerRequestPostDTO;
import com.topcare.petshop.controller.dto.customer.CustomerRequestPutDTO;
import com.topcare.petshop.controller.dto.customer.CustomerResponseDTO;
import com.topcare.petshop.controller.dto.customer.CustomerResponseReviewDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * Representa um cliente do sistema, incluindo informações pessoais e dados associados.
 */
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "customer")
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
    /**
     * Constrói um Customer a partir de um DTO de solicitação para criação.
     *
     * @param customer DTO de solicitação para criação de cliente.
     */
    public Customer(CustomerRequestPostDTO customer) {
        super(customer.fullname(), customer.email(), customer.password(), customer.cpf(), UserRole.CUSTOMER);

        Contact contact = Contact.builder()
                .cellphone(customer.cellphone())
                .telephone(customer.telephone())
                .build();

        this.setContactInfo(List.of(contact));
        this.setGender(Gender.defineGender(customer.gender()));
        this.setBirth(customer.birth());
        this.setAddresses(List.of(new CustomerAddress(customer.address())));

        this.setProfileImage(CustomerImage.defaultImage());
        this.setCards(List.of());
        this.setOrders(List.of());
        this.setPets(List.of());
        this.setFavorites(List.of());
        this.setCart(new Cart());
    }

    private void setBirth(String birth) {
        this.birth = LocalDate.parse(birth);
    }
    /**
     * Converte o Customer para um DTO de resposta.
     *
     * @return DTO de resposta do cliente.
     */
    public CustomerResponseDTO toDTO() {
        List<ContactResponseDTO> contacts = this.getContactInfo().stream().map(Contact::toDTO).toList();
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
    /**
     * Atualiza o Customer com base em um DTO de solicitação para atualização.
     *
     * @param customerDTO DTO de solicitação para atualização de cliente.
     * @throws IOException Se ocorrer um erro ao processar a imagem de perfil.
     */


    public void edit(CustomerRequestPutDTO customerDTO) throws IOException {
        this.profileImage.editFromFile(customerDTO.profileImage());

        this.setFullname(customerDTO.fullname());
        this.setEmail(customerDTO.email());
        this.setCpf(customerDTO.cpf());
        this.setBirth(customerDTO.birth());
        this.setGender(Gender.defineGender(customerDTO.gender()));

        for (int i = 0; i < this.contactInfo.size(); i++) {
            ContactRequestPutDTO contactDTO = customerDTO.contacts().get(i);
            this.contactInfo.get(i).edit(contactDTO);
        }
    }

    /**
     * Converte o Customer para um DTO de resposta para revisão.
     *
     * @return DTO de resposta para revisão do cliente.
     */
    public CustomerResponseReviewDTO toReviewDTO() {
        return new CustomerResponseReviewDTO(
          this.getFullname(),
          this.profileImage.getFile()
        );
    }
}
