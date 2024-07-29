package com.topcare.petshop.service.User;

import com.topcare.petshop.Repository.UserRepository;
import com.topcare.petshop.controller.dto.User.UserGetDTO;
import com.topcare.petshop.controller.dto.User.UserRequestLoginDTO;
import com.topcare.petshop.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserServiceInt {

    private final UserRepository userRepository;
//    private final CustomerRepository customerRepository;
//    private final EmployeeRepository employeeRepository;

    @Override
    public UserGetDTO doLogin(UserRequestLoginDTO dto) {
        Optional<User> optUser = userRepository.findByEmail(dto.email());
        System.out.println(optUser);
        if(optUser.isPresent()){
            User user = optUser.get();
            if(user.getPassword().equals(dto.password())){
//            if(user.getRole().equals(CUSTOMER)){
//                Customer customer = customerRepository.findById(user.getId()).get();
//            } else {
//                Employee employee = employeeRepository.findById(user.getId()).get();
//            }
                System.out.println("Usuário Logado!");
                return user.toDto();
            } else {
                System.out.println("Senha Incorreta!");
                return null;
            }
        } else {
            System.out.println("Usuário Inexistente");
            return null;
        }
    }
}
