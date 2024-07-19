package com.topcare.petshop.controller;

import com.topcare.petshop.controller.dto.contact.ContactRequestGetDTO;
import com.topcare.petshop.controller.dto.contact.ContactRequestPostDTO;
import com.topcare.petshop.service.contact.ContactImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact")
public class ContactController  {

    private ContactImpl contact;

    @GetMapping("/{id}")
    public ResponseEntity<ContactRequestGetDTO> getContact(@PathVariable Long id){
        return new ResponseEntity<>(contact.findContactById(id) ,HttpStatus.OK);
    };


}
