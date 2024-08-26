package com.topcare.petshop.controller;

import com.topcare.petshop.controller.dto.user.NewPasswordRequestDTO;
import com.topcare.petshop.controller.dto.user.UserEmailRequestDTO;
import com.topcare.petshop.controller.dto.user.UserResponseDTO;
import com.topcare.petshop.controller.dto.user.UserRequestPostDTO;
import com.topcare.petshop.service.user.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/topcare/user")
@CrossOrigin("*")
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

    @PostMapping("/forgotPassword")
    public ResponseEntity verifyEmail(@RequestBody UserEmailRequestDTO dto) {
        try {
            return new ResponseEntity<>(
                    service.verifyEmail(dto), HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity(
                    e.getMessage(), HttpStatus.BAD_REQUEST
            );
        }
    }

    @PatchMapping("/forgotPassword/{id}")
    public ResponseEntity changePassword(@PathVariable Long id, @RequestBody NewPasswordRequestDTO dto){
        try {
            service.changePassword(id, dto);
            return new ResponseEntity<>(
                    HttpStatus.OK
            );
        } catch (Exception e){
            return new ResponseEntity<>(
                    e.getMessage(), HttpStatus.BAD_REQUEST
            );
        }
    }

}
