package com.topcare.petshop.service.contact;

import com.topcare.petshop.controller.dto.contact.ContactRequestGetDTO;
import com.topcare.petshop.controller.dto.contact.ContactRequestPostDTO;
import com.topcare.petshop.controller.dto.contact.ContactRequestPutDTO;
import com.topcare.petshop.entity.Contact;
import org.springframework.stereotype.Service;

@Service
public interface ContactInt {

    ContactRequestGetDTO findContactById (Long id);

    Contact createContact (ContactRequestPostDTO contactDTO);

    Contact editContact (ContactRequestPutDTO contactDTO);

    boolean deletContactById (Long id);
}
