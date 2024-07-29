package com.topcare.petshop.controller;

import com.topcare.petshop.controller.dto.UserGetDTO;
import com.topcare.petshop.controller.dto.UserRequestLoginDTO;
import com.topcare.petshop.service.Implementation.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Customer")
public class UserController {

    private UserServiceImpl service;

    @GetMapping
    public ResponseEntity<UserGetDTO> doLogin(@RequestBody UserRequestLoginDTO dto){
        return new ResponseEntity<>(
                service.doLogin(dto), HttpStatus.OK
        );
    }
}
