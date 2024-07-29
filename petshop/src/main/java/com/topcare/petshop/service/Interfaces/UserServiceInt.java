package com.topcare.petshop.service.Interfaces;

import com.topcare.petshop.controller.dto.UserGetDTO;
import com.topcare.petshop.controller.dto.UserRequestLoginDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserServiceInt {

    UserGetDTO doLogin(UserRequestLoginDTO dto);

}
