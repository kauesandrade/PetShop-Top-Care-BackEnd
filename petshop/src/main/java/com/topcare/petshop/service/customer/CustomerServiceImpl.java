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
/**
 * Implementa os serviços relacionados à entidade {@link Customer}.
 * Fornece métodos para manipulação de clientes, incluindo criação, leitura, atualização, exclusão e alteração de senha.
 */
@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerServiceInt {

    private final CustomerRepository repository;

    /**
     * Retorna uma lista de todos os clientes.
     *
     * @return Lista de clientes.
     */
    @Override
    public List<Customer> getCustomers() {
        return repository.findAll();
    }

    /**
     * Retorna uma lista de todos os clientes convertidos para DTOs.
     *
     * @return Lista de DTOs dos clientes.
     */
    @Override
    public List<CustomerResponseDTO> getCustomersToDTO() {
        List<Customer> customers = repository.findAll();
        return customers.stream().map(Customer::toDTO).toList();
    }

    /**
     * Retorna um cliente com base no ID fornecido.
     *
     * @param id ID do cliente.
     * @return Cliente encontrado.
     * @throws Exception Se o cliente não for encontrado.
     */
    @Override
    public Customer getCustomer(Long id) throws Exception {
        Optional<Customer> customerOptional = repository.findById(id);
        if (customerOptional.isEmpty()) {
            throw new Exception("Id de cliente não encontrado!");
        }
        return customerOptional.get();
    }

    /**
     * Retorna um DTO do cliente com base no ID fornecido.
     *
     * @param id ID do cliente.
     * @return DTO do cliente.
     * @throws Exception Se o cliente não for encontrado.
     */
    @Override
    public CustomerResponseDTO getCustomerToDTO(Long id) throws Exception {
        Optional<Customer> customerOptional = repository.findById(id);
        if (customerOptional.isEmpty()) {
            throw new Exception("Id de cliente não encontrado!");
        }
        return customerOptional.get().toDTO();
    }

    /**
     * Salva um cliente no banco de dados.
     *
     * @param customer Cliente a ser salvo.
     * @return Cliente salvo.
     */
    @Override
    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    /**
     * Salva um cliente com base no DTO fornecido.
     *
     * @param customer DTO do cliente a ser salvo.
     * @return DTO do cliente salvo.
     */
    public CustomerResponseDTO saveCustomerFromDTO(CustomerRequestPostDTO customer) {
        return repository.save(new Customer(customer)).toDTO();
    }

    /**
     * Edita um cliente existente com base no ID e no DTO fornecidos.
     *
     * @param id ID do cliente a ser editado.
     * @param customerDTO DTO com as novas informações.
     * @return DTO do cliente editado.
     * @throws Exception Se o cliente não for encontrado.
     */
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

    /**
     * Altera a senha de um cliente com base no ID e nas senhas fornecidas.
     *
     * @param id ID do cliente.
     * @param passwords DTO contendo a senha antiga e a nova senha.
     * @return DTO do cliente com a senha alterada.
     * @throws Exception Se o cliente não for encontrado ou se a senha antiga não estiver correta.
     */
    @Override
    public CustomerResponseDTO changePassword(Long id, CustomerPasswordRequestPatchDTO passwords) throws Exception {
        Customer customer = this.getCustomer(id);
        if (!customer.checkPasswords(passwords.oldPassword())) {
            throw new Exception("A senha antiga não confere!");
        }
        customer.setPassword(passwords.newPassword());
        return saveCustomer(customer).toDTO();
    }

    /**
     * Exclui um cliente com base no ID fornecido.
     *
     * @param id ID do cliente a ser excluído.
     * @throws Exception Se o cliente não for encontrado.
     */
    @Override
    public void deleteCustomer(Long id) throws Exception {
        if (!repository.existsById(id)) {
            throw new Exception("Id de cliente não encontrado!");
        }
        repository.deleteById(id);
    }
}
