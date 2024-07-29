package com.topcare.petshop.service.contact;

import com.topcare.petshop.controller.dto.contact.ContactRequestGetDTO;
import com.topcare.petshop.controller.dto.contact.ContactRequestPostDTO;
import com.topcare.petshop.controller.dto.contact.ContactRequestPutDTO;
import com.topcare.petshop.entity.Contact;
import com.topcare.petshop.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ContactImpl implements ContactInt {

    private final ContactRepository repository;

    public ContactImpl(ContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public ContactRequestGetDTO findContactById(Long id) {
        Optional<Contact> optionalContact = repository.findById(id);

        if (optionalContact.isPresent()) {
            Contact contact = optionalContact.get();
            return contact.toDTO();
        } else {
            throw new RuntimeException("Contato não encontrado com ID: " + id);
        }
    }

    @Override
    public Contact createContact(ContactRequestPostDTO contactDTO) {
        Contact newContact = new Contact();
        newContact.setCellphone(contactDTO.cellphone());
        newContact.setTelephone(contactDTO.telephone());

        return repository.save(newContact);
    }

    @Override
    public Contact editContact(ContactRequestPutDTO contactDTO) {
        Optional<Contact> optionalContact = repository.findById(contactDTO.id());

        if (optionalContact.isPresent()) {
            Contact existingContact = optionalContact.get();

            if (contactDTO.cellphone() != null) {
                existingContact.setCellphone(contactDTO.cellphone());
            }
            if (contactDTO.telephone() != null) {
                existingContact.setTelephone(contactDTO.telephone());
            }

            return repository.save(existingContact);
        } else {
            throw new RuntimeException("Contato não encontrado com ID: " + contactDTO.id());
        }
    }

    @Override
    public boolean deletContactById(Long id) {
        return deleteContactById(id);
    }

    @Override
    public boolean deleteContactById(Long id) {
        Optional<Contact> optionalContact = repository.findById(id);

        if (optionalContact.isPresent()) {
            repository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Contato não encontrado com ID: " + id);
        }
    }
}
