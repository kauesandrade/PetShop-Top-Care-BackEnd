package com.topcare.petshop.service.card;

import com.topcare.petshop.controller.dto.card.CardRequestDTO;
import com.topcare.petshop.controller.dto.card.CardResponseDTO;
import com.topcare.petshop.entity.Card;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardServiceInt {

    CardResponseDTO getCardToDTO(Long id) throws Exception;
    Card getCard(Long id) throws Exception;
    List<CardResponseDTO> getAllCards();
    List<Card> getCardsOfUser(Long userId);
    List<CardResponseDTO> getCardsOfUserToDTO(Long userId);
    CardResponseDTO registerCard(CardRequestDTO dto) throws Exception;
    CardResponseDTO editCard(Long id, CardRequestDTO dto) throws Exception;
    void deleteCard(Long id) throws Exception;

}
