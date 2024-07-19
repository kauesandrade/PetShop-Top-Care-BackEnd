package com.topcare.petshop.service.contact;

import com.topcare.petshop.controller.dto.contact.ContactRequestGetDTO;
import com.topcare.petshop.controller.dto.contact.ContactRequestPostDTO;
import com.topcare.petshop.controller.dto.contact.ContactRequestPutDTO;
import com.topcare.petshop.entity.Contact;
import com.topcare.petshop.repository.ContactRepository;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContactImpl implements ContactInt {

    private ContactRepository repository;

    @Override
    public ContactRequestGetDTO findContactById(Long id) {
        Contact contact = repository.findById(id).get();


        return null;
    }

    @Override
    public Contact createContact(ContactRequestPostDTO contactDTO) {
        return null;
    }

    @Override
    public Contact editContact(ContactRequestPutDTO contactDTO) {
        return null;
    }

    @Override
    public boolean deletContactById(Long id) {
        return false;
    }
}
