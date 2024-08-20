package com.topcare.petshop.service.user;

import com.topcare.petshop.controller.dto.user.*;
import com.topcare.petshop.repository.UserRepository;
import com.topcare.petshop.entity.Customer;
import com.topcare.petshop.entity.User;
import com.topcare.petshop.entity.UserRole;
import com.topcare.petshop.service.customer.CustomerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserServiceInt {

    private final UserRepository repository;
//    private final CustomerServiceImpl customerService;
//    private final EmployeeServiceImpl employeeService;

    @Override
    public UserResponseDTO doLogin(UserRequestPostDTO dto) throws Exception {
        Optional<User> optUser = repository.findByEmail(dto.email());

        if (optUser.isEmpty()) {
            throw new Exception("Dados incorretos");
        }

        User user = optUser.get();

        if (!user.checkPasswords(dto.password())) {
            throw new Exception("Dados incorretos");
        }

//        Ver como retorna 2 tipos de usuario diferente
//        if (user.getRole().equals(UserRole.CUSTOMER)) {
//            Customer customer = customerService.getCustomer(user.getId());
//            System.out.println(customer.toDTO());
//        } else {
//                Employee employee = employeeRepository.findById(user.getId()).get();
//            }
        return user.toDto();
    }

    @Override
    public ForgotPasswordResponseDTO verifyEmail(UserEmailRequestDTO dto) throws Exception {
        Optional<User> optUser = repository.findByEmail(dto.email());

        if (optUser.isEmpty()){
            throw new Exception("Usuário inexistente");
        }

        Random rand = new Random();
        return new ForgotPasswordResponseDTO(optUser.get().getId(), rand.nextLong(999999 - 100000));

    }

    @Override
    public void changePassword(Long id, NewPasswordRequestDTO dto) throws Exception {
        Optional<User> optUser = repository.findById(id);

        if (optUser.isEmpty()){
            throw new Exception("Usuário inexistente");
        }

        User user = optUser.get();
        user.setPassword(dto.newPassword());
        repository.save(user);
    }
}
