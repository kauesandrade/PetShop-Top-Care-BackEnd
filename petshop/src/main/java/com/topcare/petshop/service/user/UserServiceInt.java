package com.topcare.petshop.service.user;

import com.topcare.petshop.controller.dto.user.UserResponseDTO;
import com.topcare.petshop.controller.dto.user.UserRequestPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserServiceInt {

    UserResponseDTO doLogin(UserRequestPostDTO dto) throws Exception;

}
