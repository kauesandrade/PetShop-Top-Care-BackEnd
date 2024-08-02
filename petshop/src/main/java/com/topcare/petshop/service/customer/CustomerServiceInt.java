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

@Service
public interface CustomerServiceInt {


    List<CustomerResponseDTO> getCustomers();

    Customer getCustomer(Long id) throws Exception;

    CustomerResponseDTO getCustomerToDTO(Long id) throws Exception;

    Card getCustomerMainCard(Long id) throws Exception;

    CardResponseDTO getCustomerMainCardToDTO(Long id) throws Exception;

    CustomerResponseDTO saveCustomer(CustomerRequestPostDTO customer);

    CustomerResponseDTO editCustomer(Long id, CustomerRequestPutDTO customerDTO) throws Exception;

    CustomerResponseDTO changePassword(Long id, CustomerPasswordRequestPatchDTO passwords) throws Exception;

    void deleteCustomer(Long id) throws Exception;
}
