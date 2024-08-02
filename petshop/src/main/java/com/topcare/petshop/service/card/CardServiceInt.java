package com.topcare.petshop.service.card;

import com.topcare.petshop.controller.dto.card.CardRequestDTO;
import com.topcare.petshop.controller.dto.card.CardResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface CardServiceInt {

    CardResponseDTO getCard(Long id);
    CardResponseDTO registerCard(CardRequestDTO dto);
    CardResponseDTO editCard(Long id, CardRequestDTO dto);

}
