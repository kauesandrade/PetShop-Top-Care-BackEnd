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
/**
 * Implementa serviços relacionados ao usuário, incluindo autenticação e gerenciamento de senha.
 * Fornece métodos para login, verificação de e-mail para recuperação de senha e alteração de senha.
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserServiceInt {

    private final UserRepository repository;

    /**
     * Realiza o login do usuário com base no e-mail e senha fornecidos.
     *
     * @param dto DTO contendo e-mail e senha do usuário.
     * @return DTO contendo informações do usuário autenticado.
     * @throws Exception Se as credenciais estiverem incorretas.
     */
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

        // Código comentado para casos de diferentes tipos de usuários, se necessário
        // if (user.getRole().equals(UserRole.CUSTOMER)) {
        //     Customer customer = customerService.getCustomer(user.getId());
        //     System.out.println(customer.toDTO());
        // } else {
        //     Employee employee = employeeRepository.findById(user.getId()).get();
        // }

        return user.toDto();
    }

    /**
     * Verifica o e-mail do usuário para recuperação de senha.
     *
     * @param dto DTO contendo o e-mail do usuário.
     * @return DTO contendo o ID do usuário e um código de verificação para recuperação de senha.
     * @throws Exception Se o e-mail não estiver cadastrado.
     */
    @Override
    public ForgotPasswordResponseDTO verifyEmail(UserEmailRequestDTO dto) throws Exception {
        Optional<User> optUser = repository.findByEmail(dto.email());

        if (optUser.isEmpty()) {
            throw new Exception("Usuário inexistente");
        }

        Random rand = new Random();
        return new ForgotPasswordResponseDTO(optUser.get().getId(), rand.nextLong(999999 - 100000));
    }

    /**
     * Altera a senha do usuário com base no ID e nova senha fornecidos.
     *
     * @param id ID do usuário cuja senha será alterada.
     * @param dto DTO contendo a nova senha.
     * @throws Exception Se o usuário não existir.
     */
    @Override
    public void changePassword(Long id, NewPasswordRequestDTO dto) throws Exception {
        Optional<User> optUser = repository.findById(id);

        if (optUser.isEmpty()) {
            throw new Exception("Usuário inexistente");
        }

        User user = optUser.get();
        user.setPassword(dto.newPassword());
        repository.save(user);
    }
}
