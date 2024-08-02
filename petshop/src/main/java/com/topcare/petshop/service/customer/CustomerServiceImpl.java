package com.topcare.petshop.service.customer;

import com.topcare.petshop.controller.dto.card.CardResponseDTO;
import com.topcare.petshop.controller.dto.customer.CustomerPasswordRequestPatchDTO;
import com.topcare.petshop.controller.dto.customer.CustomerRequestPostDTO;
import com.topcare.petshop.controller.dto.customer.CustomerRequestPutDTO;
import com.topcare.petshop.controller.dto.customer.CustomerResponseDTO;
import com.topcare.petshop.entity.Card;
import com.topcare.petshop.entity.Customer;
import com.topcare.petshop.entity.CustomerImage;
import com.topcare.petshop.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerServiceInt {

    private final CustomerRepository repository;

    @Override
    public List<CustomerResponseDTO> getCustomers() {
        List<Customer> customers = repository.findAll();
        return customers.stream().map(Customer::toDTO).toList();
    }

    @Override
    public Customer getCustomer(Long id) throws Exception {
        Optional<Customer> customerOptional = repository.findById(id);
        if (customerOptional.isEmpty()) {
            throw new Exception("Id de cliente não encontrado!");
        }

        return customerOptional.get();
    }

    @Override
    public CustomerResponseDTO getCustomerToDTO(Long id) throws Exception {
        Optional<Customer> customerOptional = repository.findById(id);
        if (customerOptional.isEmpty()) {
            throw new Exception("Id de cliente não encontrado!");
        }

        Customer customer = customerOptional.get();
        return customer.toDTO();
    }

    @Override
    public Card getCustomerMainCard(Long id) throws Exception {
        if (!repository.existsById(id)) {
            throw new Exception("Id de cliente não encontrado!");
        }

        return repository.findByIdAndMainCardIsTrue(id).orElseThrow(() -> new Exception("Cartão principal não encontrado!"));
    }

    public CardResponseDTO getCustomerMainCardToDTO(Long id) throws Exception {
        if (!repository.existsById(id)) {
            throw new Exception("Id de cliente não encontrado!");
        }

        Optional<Card> cardOpt = repository.findByIdAndMainCardIsTrue(id);

        if (cardOpt.isEmpty()) {
            throw new Exception("Cartão principal não encontrado!");
        }

        return cardOpt.get().toDTO();
    }

    public CustomerResponseDTO saveCustomer(CustomerRequestPostDTO customer) {
        return repository.save(new Customer(customer)).toDTO();
    }

    @Override
    public CustomerResponseDTO editCustomer(Long id, CustomerRequestPutDTO customerDTO) throws Exception {
        Optional<Customer> customerOptional = repository.findById(id);
        if (customerOptional.isEmpty()) {
            throw new Exception("Id de cliente não encontrado!");
        }

        Customer customer = customerOptional.get();
        customer = customer.edit(customerDTO);

        return repository.save(customer).toDTO();
    }

    @Override
    public CustomerResponseDTO changePassword(Long id, CustomerPasswordRequestPatchDTO passwords) throws Exception {
        Customer customer = repository.findById(id).get();
        if (!customer.getPassword().equals(passwords.oldPassword())) {
            throw new Exception("A senha antiga não confere!");
        }
        customer.setPassword(passwords.newPassword());
        return repository.save(customer).toDTO();
    }

    @Override
    public void deleteCustomer(Long id) throws Exception {
        if (!repository.existsById(id)) {
            throw new Exception("Id de cliente não encontrado!");
        }
        repository.deleteById(id);
    }

}