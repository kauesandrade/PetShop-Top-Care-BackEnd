package com.topcare.petshop.service.card;

import com.topcare.petshop.controller.dto.card.CardRequestDTO;
import com.topcare.petshop.repository.CardRepository;
import com.topcare.petshop.controller.dto.card.CardResponseDTO;
import com.topcare.petshop.entity.Card;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CardServiceImpl implements CardServiceInt {

    private CardRepository repository;

    @Override
    public CardResponseDTO getCard(Long id) {
        Card card = repository.findById(id).get();
        return card.toDto();
    }

    @Override
    public CardResponseDTO registerCard(CardRequestDTO dto) {
        Card newCard = new Card();
        newCard.setName(dto.name());
        newCard.setExpirationDate(dto.expirationDate());
        newCard.setLastDigits(dto.lastDigits());

        if (!dto.mainCard()){
            newCard.setMainCard(dto.mainCard());
            repository.save(newCard);
            return newCard.toDto();
        }

        Card oldCard = repository.findByMainCard(true).get();

        newCard.setMainCard(dto.mainCard());
        oldCard.setMainCard(false);
        repository.save(newCard);
        repository.save(oldCard);
        return newCard.toDto();
    }

    @Override
    public CardResponseDTO editCard(Long id, CardRequestDTO dto) {
        return null;
    }
}
