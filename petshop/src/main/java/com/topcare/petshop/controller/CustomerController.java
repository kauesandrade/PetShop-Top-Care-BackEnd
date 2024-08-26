package com.topcare.petshop.controller;

import com.topcare.petshop.controller.dto.customer.*;
import com.topcare.petshop.service.customer.CustomerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/topcare/customer")
@CrossOrigin("*")
@AllArgsConstructor
public class CustomerController {

    private final CustomerServiceImpl service;

    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomers() {
        return new ResponseEntity(service.getCustomersToDTO(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCustomerById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getCustomerToDTO(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody CustomerRequestPostDTO customer) {
        return new ResponseEntity(service.saveCustomerFromDTO(customer), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    // Tem q ser form-data p poder receber a imagem
    public ResponseEntity editCustomer(@PathVariable Long id, @RequestPart MultipartFile profileImage, @RequestPart CustomerWoImageRequestPutDTO customer) {
        CustomerRequestPutDTO customerDTO = new CustomerRequestPutDTO(
                profileImage,
                customer.fullname(),
                customer.email(),
                customer.cpf(),
                customer.birth(),
                customer.gender(),
                customer.contacts()
        );
        try {
            return new ResponseEntity(service.editCustomerFromDTO(id, customerDTO), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity changePassword(@PathVariable Long id, @RequestBody CustomerPasswordRequestPatchDTO passwords) {
        try {
            return new ResponseEntity(service.changePassword(id, passwords), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Long id) {
        try {
            service.deleteCustomer(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}

