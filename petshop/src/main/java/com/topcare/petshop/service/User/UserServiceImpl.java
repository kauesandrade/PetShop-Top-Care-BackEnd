package com.topcare.petshop.service.User;

import com.topcare.petshop.Repository.UserRepository;
import com.topcare.petshop.controller.dto.User.UserGetDTO;
import com.topcare.petshop.controller.dto.User.UserRequestLoginDTO;
import com.topcare.petshop.entity.Customer;
import com.topcare.petshop.entity.Employee;
import com.topcare.petshop.entity.User;
import com.topcare.petshop.entity.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserServiceInt {

    private final UserRepository repository;
    private final CustomerService customerService;
//    private final EmployeeService employeeService;

    @Override
    public UserGetDTO doLogin(UserRequestLoginDTO dto) {
        Optional<User> optUser = repository.findByEmail(dto.email());
        System.out.println(optUser);
        if(optUser.isPresent()){
            User user = optUser.get();
            if(user.getPassword().equals(dto.password())){
            if(user.getRole().equals(UserRole.CUSTOMER)){
                Customer customer = customerService.getCustomer(user.getId());
            } //else {
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
