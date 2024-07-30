package com.topcare.petshop.service.Card;

import com.topcare.petshop.Repository.CardRepository;
import com.topcare.petshop.controller.dto.card.CardRequestGetPostDTO;
import com.topcare.petshop.entity.Card;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CardServiceImpl implements CardServiceInt {

    private CardRepository repository;

    @Override
    public CardRequestGetPostDTO getCard(Long id) {
        Card card = repository.findById(id).get();
        return card.toDto();
    }

    @Override
    public CardRequestGetPostDTO registerCard(CardRequestGetPostDTO dto) {
        return null;
    }
}
