package com.topcare.petshop.controller;

import com.topcare.petshop.controller.dto.customer.*;
import com.topcare.petshop.entity.CustomerImage;
import com.topcare.petshop.entity.Image;
import com.topcare.petshop.service.customer.CustomerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Controlador para gerenciamento de clientes.
 */
@RestController
@RequestMapping("/topcare/customer")
@CrossOrigin("*")
@AllArgsConstructor
public class CustomerController {

    private final CustomerServiceImpl service;

    /**
     * Obtém todos os clientes.
     *
     * @return Lista de todos os clientes.
     */
    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomers() {
        return new ResponseEntity(service.getCustomersToDTO(), HttpStatus.OK);
    }

    /**
     * Obtém um cliente pelo ID.
     *
     * @param id ID do cliente.
     * @return Cliente correspondente ou mensagem de erro.
     */
    @GetMapping("/{id}")
    public ResponseEntity getCustomerById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getCustomerToDTO(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * Cria um novo cliente.
     *
     * @param customer Dados do cliente a ser criado.
     * @return Cliente criado.
     */
    @PostMapping
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody CustomerRequestPostDTO customer) {
        return new ResponseEntity(service.saveCustomerFromDTO(customer), HttpStatus.CREATED);
    }

    /**
     * Edita um cliente existente.
     *
     * @param id ID do cliente a ser editado.
     * @param profileImage Imagem de perfil do cliente.
     * @param customer Dados atualizados do cliente.
     * @return Cliente editado ou mensagem de erro.
     */
    @PutMapping(value = "/{id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity editCustomer(@PathVariable Long id, MultipartFile profileImage, @RequestPart CustomerWoImageRequestPutDTO customer) {
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

    /**
     * Altera a senha de um cliente.
     *
     * @param id ID do cliente.
     * @param passwords Dados da nova senha.
     * @return Status OK ou mensagem de erro.
     */
    @PatchMapping("/{id}")
    public ResponseEntity changePassword(@PathVariable Long id, @RequestBody CustomerPasswordRequestPatchDTO passwords) {
        try {
            return new ResponseEntity(service.changePassword(id, passwords), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Deleta um cliente pelo ID.
     *
     * @param id ID do cliente a ser deletado.
     * @return Status OK ou mensagem de erro.
     */
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
