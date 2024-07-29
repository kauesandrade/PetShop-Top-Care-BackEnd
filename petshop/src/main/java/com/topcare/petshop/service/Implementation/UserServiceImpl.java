package com.topcare.petshop.service.Implementation;

import com.topcare.petshop.Repository.UserRepository;
import com.topcare.petshop.controller.dto.UserGetDTO;
import com.topcare.petshop.controller.dto.UserRequestLoginDTO;
import com.topcare.petshop.entity.Customer;
import com.topcare.petshop.service.Interfaces.UserServiceInt;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserServiceInt {

    private UserRepository repository;

    @Override
    public UserGetDTO doLogin(UserRequestLoginDTO dto) {
        Customer customer = repository.findByEmail(dto.email()).get();

        System.out.println(customer);

        return customer.toDto();

    }
}
