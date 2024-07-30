package com.topcare.petshop.service.customer;

import com.topcare.petshop.controller.dto.customer.CustomerRequestPostDTO;
import com.topcare.petshop.controller.dto.customer.CustomerResponseGetDTO;
import com.topcare.petshop.entity.Customer;
import com.topcare.petshop.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl {

    private final CustomerRepository repository;

    public CustomerResponseGetDTO saveCustomer(CustomerRequestPostDTO customer) {
        return repository.save(new Customer(customer)).toDTO();
    }

    public List<CustomerResponseGetDTO> getCustomers() {
        List<Customer> customers = repository.findAll();
        return customers.stream().map(Customer::toDTO).toList();
    }

    public CustomerResponseGetDTO getCustomerById(Long id) {
        Customer customer = repository.findById(id).get();
        return customer.toDTO();
    }

    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }

}
