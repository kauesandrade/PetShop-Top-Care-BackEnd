package com.topcare.petshop.service.User;

import com.topcare.petshop.controller.dto.User.UserGetDTO;
import com.topcare.petshop.controller.dto.User.UserRequestLoginDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserServiceInt {

    UserGetDTO doLogin(UserRequestLoginDTO dto);

}
