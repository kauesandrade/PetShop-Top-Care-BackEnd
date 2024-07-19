package com.topcare.petshop.service.contact;

import com.topcare.petshop.controller.dto.contact.ContactRequestGetDTO;
import com.topcare.petshop.controller.dto.contact.ContactRequestPostDTO;
import com.topcare.petshop.controller.dto.contact.ContactRequestPutDTO;
import com.topcare.petshop.entity.Contact;
import com.topcare.petshop.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@AllArgsConstructor
public class ContactImpl implements ContactInt {

    private ContactRepository repository;

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
        newContact.setCellphone(contactDTO.getCellphone());
        newContact.setTelephone(contactDTO.getTelephone()); // Verifica se o método getTelephone está sendo reconhecido corretamente

        return (Contact) repository.save(newContact);
    }


    @Override
    public Contact editContact(ContactRequestPutDTO contactDTO) {
        Optional<Contact> optionalContact = repository.findById(contactDTO.getId());

        if (optionalContact.isPresent()) {
            Contact existingContact = optionalContact.get();

            if (contactDTO.getCellphone() != null) {
                existingContact.setCellphone(contactDTO.getCellphone());
            }
            if (contactDTO.getTelephone() != null) {
                existingContact.setTelephone(contactDTO.getTelephone());
            }

            return (Contact) repository.save(existingContact);

        } else {
            throw new RuntimeException("Contact not found with id: " + id);
        }
    }


    @Override
    public boolean deletContactById(Long id) {
        return false;
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

