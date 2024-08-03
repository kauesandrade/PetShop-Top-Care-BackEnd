package com.topcare.petshop.service.user;

import com.topcare.petshop.controller.dto.user.*;
import org.springframework.stereotype.Service;

@Service
public interface UserServiceInt {

    UserResponseDTO doLogin(UserRequestPostDTO dto) throws Exception;
    ForgotPasswordResponseDTO verifyEmail(UserEmailRequestDTO dto) throws Exception;
    void changePassword(Long id, NewPasswordRequestDTO dto) throws Exception;
}
