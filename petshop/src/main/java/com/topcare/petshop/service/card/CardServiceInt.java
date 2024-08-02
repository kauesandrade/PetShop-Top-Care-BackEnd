package com.topcare.petshop.service.card;

import com.topcare.petshop.controller.dto.card.CardRequestDTO;
import com.topcare.petshop.controller.dto.card.CardResponseDTO;
import com.topcare.petshop.entity.Card;
import org.springframework.stereotype.Service;

@Service
public interface CardServiceInt {

    Card getCard(Long id);
    CardResponseDTO registerCard(CardRequestDTO dto) throws Exception;
    CardResponseDTO editCard(Long id, CardRequestDTO dto) throws Exception;
    void deleteCard(Long id) throws Exception;

}
