package com.topcare.petshop.service.customer;

import com.topcare.petshop.controller.dto.customer.CustomerPasswordRequestPatchDTO;
import com.topcare.petshop.controller.dto.customer.CustomerRequestPostDTO;
import com.topcare.petshop.controller.dto.customer.CustomerRequestPutDTO;
import com.topcare.petshop.controller.dto.customer.CustomerResponseDTO;
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
    public CustomerResponseDTO getCustomerById(Long id) throws Exception {
        Optional<Customer> customerOptional = repository.findById(id);
        if (customerOptional.isEmpty()) {
            throw new Exception("Id de cliente não encontrado!");
        }

        Customer customer = customerOptional.get();
        return customer.toDTO();
    }

    @Override
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

        customer.setProfileImage(new CustomerImage(customerDTO.profileImage().getBytes(StandardCharsets.UTF_8)));
        customer.setFullname(customerDTO.fullname());
        customer.setEmail(customerDTO.email());
        customer.setCpf(customerDTO.cpf());
        customer.setBirth(customerDTO.birth());
        customer.setGender(customerDTO.gender());

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