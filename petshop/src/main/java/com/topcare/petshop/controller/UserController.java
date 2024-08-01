package com.topcare.petshop.controller;

import com.topcare.petshop.controller.dto.user.UserResponseDTO;
import com.topcare.petshop.controller.dto.user.UserRequestPostDTO;
import com.topcare.petshop.service.user.UserServiceImpl;
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
    public ResponseEntity doLogin(@RequestBody UserRequestPostDTO dto) {
        try {
            return new ResponseEntity<>(
                    service.doLogin(dto), HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    e.getMessage(), HttpStatus.BAD_REQUEST
            );
        }
    }
}
