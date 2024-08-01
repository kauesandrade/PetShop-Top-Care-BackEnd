package com.topcare.petshop.service.customer;

import com.topcare.petshop.controller.dto.customer.CustomerPasswordRequestPatchDTO;
import com.topcare.petshop.controller.dto.customer.CustomerRequestPostDTO;
import com.topcare.petshop.controller.dto.customer.CustomerRequestPutDTO;
import com.topcare.petshop.controller.dto.customer.CustomerResponseDTO;
import com.topcare.petshop.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerServiceInt {


    List<CustomerResponseDTO> getCustomers();

    Customer getCustomer(Long id) throws Exception;

    CustomerResponseDTO getCustomerById(Long id) throws Exception;

    CustomerResponseDTO saveCustomer(CustomerRequestPostDTO customer);

    CustomerResponseDTO editCustomer(Long id, CustomerRequestPutDTO customerDTO) throws Exception;

    CustomerResponseDTO changePassword(Long id, CustomerPasswordRequestPatchDTO passwords) throws Exception;

    void deleteCustomer(Long id) throws Exception;
}
