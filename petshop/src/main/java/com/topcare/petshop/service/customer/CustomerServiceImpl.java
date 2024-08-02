package com.topcare.petshop.service.customer;

import com.topcare.petshop.controller.dto.card.CardResponseDTO;
import com.topcare.petshop.controller.dto.customer.CustomerPasswordRequestPatchDTO;
import com.topcare.petshop.controller.dto.customer.CustomerRequestPostDTO;
import com.topcare.petshop.controller.dto.customer.CustomerRequestPutDTO;
import com.topcare.petshop.controller.dto.customer.CustomerResponseDTO;
import com.topcare.petshop.entity.Card;
import com.topcare.petshop.entity.Customer;
import com.topcare.petshop.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerServiceInt {

    private final CustomerRepository repository;

    @Override
    public List<Customer> getCustomers() {
        return repository.findAll();
    }

    @Override
    public List<CustomerResponseDTO> getCustomersToDTO() {
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
    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    public CustomerResponseDTO saveCustomerFromDTO(CustomerRequestPostDTO customer) {
        return repository.save(new Customer(customer)).toDTO();
    }

    @Override
    public CustomerResponseDTO editCustomerFromDTO(Long id, CustomerRequestPutDTO customerDTO) throws Exception {
        Optional<Customer> customerOptional = repository.findById(id);
        if (customerOptional.isEmpty()) {
            throw new Exception("Id de cliente não encontrado!");
        }

        Customer customer = customerOptional.get();
        customer.edit(customerDTO);

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