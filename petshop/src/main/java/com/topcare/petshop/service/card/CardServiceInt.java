package com.topcare.petshop.service.card;

import com.topcare.petshop.controller.dto.card.CardRequestDTO;
import com.topcare.petshop.controller.dto.card.CardResponseDTO;
import com.topcare.petshop.entity.Card;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardServiceInt {

    CardResponseDTO getCardDTO(Long id);
    Card getCard(Long id);
    List<CardResponseDTO> getAllCards();
    CardResponseDTO registerCard(CardRequestDTO dto) throws Exception;
    CardResponseDTO editCard(Long id, CardRequestDTO dto) throws Exception;
    void deleteCard(Long id) throws Exception;

}
