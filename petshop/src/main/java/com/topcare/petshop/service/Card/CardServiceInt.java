package com.topcare.petshop.service.Card;

import com.topcare.petshop.controller.dto.card.CardRequestGetPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface CardServiceInt {

    CardRequestGetPostDTO getCard(Long id);
    CardRequestGetPostDTO registerCard(CardRequestGetPostDTO dto);

}
