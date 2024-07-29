package com.topcare.petshop.controller;

import com.topcare.petshop.controller.dto.User.UserGetDTO;
import com.topcare.petshop.controller.dto.User.UserRequestLoginDTO;
import com.topcare.petshop.service.User.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/topcare/user")
public class UserController {

    private final UserServiceImpl service;

    @PostMapping
    public ResponseEntity<UserGetDTO> doLogin(@RequestBody UserRequestLoginDTO dto){
        return new ResponseEntity<>(
                service.doLogin(dto), HttpStatus.OK
        );
    }
}
