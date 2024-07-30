package com.topcare.petshop.controller;

import com.topcare.petshop.controller.dto.customer.CustomerRequestPostDTO;
import com.topcare.petshop.controller.dto.customer.CustomerResponseGetDTO;
import com.topcare.petshop.service.customer.CustomerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/topcare/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerServiceImpl service;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseGetDTO> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCustomerById(id));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseGetDTO>> getCustomers() {
        return ResponseEntity.ok(service.getCustomers());
    }

    @PostMapping
    public ResponseEntity<CustomerResponseGetDTO> createCustomer(@RequestBody CustomerRequestPostDTO customer) {
        return ResponseEntity.ok(service.saveCustomer(customer));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

}
