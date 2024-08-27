package com.topcare.petshop.service.user;

import com.topcare.petshop.controller.dto.user.*;
import com.topcare.petshop.repository.UserRepository;
import com.topcare.petshop.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserServiceInt {

    private final UserRepository repository;

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

        return user.toDto();
    }

    @Override
    public UserForgotpasswordDTO verifyEmail(UserEmailRequestDTO dto) throws Exception {
        Optional<User> optUser = repository.findByEmail(dto.email());

        if (optUser.isEmpty()){
            throw new Exception("Usuário inexistente");
        }

        return optUser.get().toForgotPasswordDto();

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

    @Override
    public ForgotPasswordCodeResponseDTO getCode() {
        Random rand = new Random();
        return new ForgotPasswordCodeResponseDTO(100000 + rand.nextLong(900000));
    }
}
