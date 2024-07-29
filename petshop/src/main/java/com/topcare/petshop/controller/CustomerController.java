package com.topcare.petshop.controller;

import com.topcare.petshop.controller.dto.CustomerRequestGetDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Customer")
public class CustomerController {

    @GetMapping("/{id}")
    public ResponseEntity<CustomerRequestGetDTO> doLogin(@PathVariable Long id){
        return null;
    }
}
