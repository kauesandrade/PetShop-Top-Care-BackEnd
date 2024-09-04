package com.topcare.petshop.service.customer;

import com.topcare.petshop.controller.dto.card.CardResponseDTO;
import com.topcare.petshop.controller.dto.customer.CustomerPasswordRequestPatchDTO;
import com.topcare.petshop.controller.dto.customer.CustomerRequestPostDTO;
import com.topcare.petshop.controller.dto.customer.CustomerRequestPutDTO;
import com.topcare.petshop.controller.dto.customer.CustomerResponseDTO;
import com.topcare.petshop.entity.Card;
import com.topcare.petshop.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Interface para os serviços relacionados à entidade {@link Customer}.
 * Define os métodos para manipulação de clientes, incluindo criação, leitura, atualização, exclusão e alteração de senha.
 */
@Service
public interface CustomerServiceInt {

    /**
     * Retorna uma lista de todos os clientes.
     *
     * @return Lista de clientes.
     */
    List<Customer> getCustomers();

    /**
     * Retorna uma lista de todos os clientes convertidos para DTOs.
     *
     * @return Lista de DTOs dos clientes.
     */
    List<CustomerResponseDTO> getCustomersToDTO();

    /**
     * Retorna um cliente com base no ID fornecido.
     *
     * @param id ID do cliente.
     * @return Cliente encontrado.
     * @throws Exception Se o cliente não for encontrado.
     */
    Customer getCustomer(Long id) throws Exception;

    /**
     * Retorna um DTO do cliente com base no ID fornecido.
     *
     * @param id ID do cliente.
     * @return DTO do cliente.
     * @throws Exception Se o cliente não for encontrado.
     */
    CustomerResponseDTO getCustomerToDTO(Long id) throws Exception;

    /**
     * Salva um cliente no banco de dados.
     *
     * @param customer Cliente a ser salvo.
     * @return Cliente salvo.
     */
    Customer saveCustomer(Customer customer);

    /**
     * Salva um cliente com base no DTO fornecido.
     *
     * @param customer DTO do cliente a ser salvo.
     * @return DTO do cliente salvo.
     */
    CustomerResponseDTO saveCustomerFromDTO(CustomerRequestPostDTO customer);

    /**
     * Edita um cliente existente com base no ID e no DTO fornecidos.
     *
     * @param id ID do cliente a ser editado.
     * @param customerDTO DTO com as novas informações.
     * @return DTO do cliente editado.
     * @throws Exception Se o cliente não for encontrado.
     */
    CustomerResponseDTO editCustomerFromDTO(Long id, CustomerRequestPutDTO customerDTO) throws Exception;

    /**
     * Altera a senha de um cliente com base no ID e nas senhas fornecidas.
     *
     * @param id ID do cliente.
     * @param passwords DTO contendo a senha antiga e a nova senha.
     * @return DTO do cliente com a senha alterada.
     * @throws Exception Se o cliente não for encontrado ou se a senha antiga não estiver correta.
     */
    CustomerResponseDTO changePassword(Long id, CustomerPasswordRequestPatchDTO passwords) throws Exception;

    /**
     * Exclui um cliente com base no ID fornecido.
     *
     * @param id ID do cliente a ser excluído.
     * @throws Exception Se o cliente não for encontrado.
     */
    void deleteCustomer(Long id) throws Exception;
}
