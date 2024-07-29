package com.topcare.petshop.controller;

import com.topcare.petshop.controller.dto.contact.ContactRequestGetDTO;
import com.topcare.petshop.controller.dto.contact.ContactRequestPostDTO;
import com.topcare.petshop.controller.dto.contact.ContactRequestPutDTO;
import com.topcare.petshop.entity.Contact;
import com.topcare.petshop.service.contact.ContactImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contact")
@AllArgsConstructor
public class ContactController {

    private final ContactImpl contactService;

    public ContactController(ContactImpl contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactRequestGetDTO> getContact(@PathVariable Long id) {
        return new ResponseEntity<>(contactService.findContactById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody ContactRequestPostDTO contactDTO) {
        return new ResponseEntity<>(contactService.createContact(contactDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> editContact(@PathVariable Long id, @RequestBody ContactRequestPutDTO contactDTO) {
        contactDTO = new ContactRequestPutDTO(id, contactDTO.cellphone(), contactDTO.telephone());
        return new ResponseEntity<>(contactService.editContact(contactDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        contactService.deleteContactById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
