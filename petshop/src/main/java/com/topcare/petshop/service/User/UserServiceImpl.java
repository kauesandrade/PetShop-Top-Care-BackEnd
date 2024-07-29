package com.topcare.petshop.service.User;

import com.topcare.petshop.Repository.CustomerRepository;
import com.topcare.petshop.Repository.EmployeeRepository;
import com.topcare.petshop.Repository.UserRepository;
import com.topcare.petshop.controller.dto.User.UserGetDTO;
import com.topcare.petshop.controller.dto.User.UserRequestLoginDTO;
import com.topcare.petshop.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.topcare.petshop.entity.UserRole.CUSTOMER;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserServiceInt {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public UserGetDTO doLogin(UserRequestLoginDTO dto) {
        User user = userRepository.findByEmail(dto.email()).get();

        System.out.println(user);
        System.out.println(user.getPassword());
        System.out.println(dto.password());

        if(user.getPassword().equals(dto.password())){
            System.out.println("LOGOU PAIZAO");
            if(user.getRole().equals(CUSTOMER)){
                System.out.println("é cliente");
            } else {
                System.out.println("Trabaia");
            }
            return user.toDto();
        } else {
            System.out.println("Senha ta paia pae");
            return null;
        }
    }
}
