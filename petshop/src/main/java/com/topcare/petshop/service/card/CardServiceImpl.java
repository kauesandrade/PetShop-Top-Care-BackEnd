package com.topcare.petshop.service.card;

import com.topcare.petshop.controller.dto.card.CardRequestDTO;
import com.topcare.petshop.entity.Customer;
import com.topcare.petshop.repository.CardRepository;
import com.topcare.petshop.controller.dto.card.CardResponseDTO;
import com.topcare.petshop.entity.Card;
import com.topcare.petshop.service.customer.CustomerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CardServiceImpl implements CardServiceInt {

    private CardRepository repository;
    private CustomerServiceImpl customerService;

    @Override
    public CardResponseDTO getCardDTO(Long id) {
        Card card = repository.findById(id).get();
        return card.toDTO();
    }

    @Override
    public Card getCard(Long id) {
        Card card = repository.findById(id).get();
        return card;
    }

    @Override
    public List<CardResponseDTO> getAllCards() {
        return repository.findAll().stream().map(Card::toDTO).toList();
    }

    @Override
    public CardResponseDTO registerCard(CardRequestDTO dto) throws Exception {
        Card newCard = new Card();
        newCard.setName(dto.name());
        newCard.setExpirationDate(dto.expirationDate());
        newCard.setLastDigits(dto.lastDigits());

        Customer customer = customerService.getCustomer(dto.userId());
        newCard.setCustomer(customer);

        List<Card> cards = customer.getCards();

        if (cards.isEmpty()){
            newCard.setMainCard(true);
        } else if (!dto.mainCard()){
            newCard.setMainCard(dto.mainCard());
        } else {
            Card oldCard = repository.findByCustomer_IdAndMainCardIsTrue(dto.userId()).get();
            newCard.setMainCard(dto.mainCard());
            int indexCard = cards.indexOf(oldCard);
            oldCard.setMainCard(false);
            cards.set(indexCard, oldCard);
        }
        cards.add(newCard);
        customerService.saveCustomer(customer);
        return newCard.toDTO();
    }

    @Override
    public CardResponseDTO editCard(Long id, CardRequestDTO dto) throws Exception {
        Card newCard = getCard(id);
        newCard.setName(dto.name());
        newCard.setExpirationDate(dto.expirationDate());
        newCard.setLastDigits(dto.lastDigits());

        Customer customer = customerService.getCustomer(dto.userId());
        newCard.setCustomer(customer);
        newCard.setMainCard(dto.mainCard());
        Card oldCard = repository.findByCustomer_IdAndMainCardIsTrue(dto.userId()).get();

        if (dto.mainCard() && !Objects.equals(newCard.getId(), oldCard.getId())){
            oldCard.setMainCard(false);
        }
        customerService.saveCustomer(customer);
        return newCard.toDTO();
    }

    @Override
    public void deleteCard(Long id) throws Exception {
        Optional<Card> optCard = repository.findById(id);
        if(optCard.isEmpty()){
            throw new Exception("Cartão não encontrado");
        }
        Card card = optCard.get();
        repository.deleteById(id);
        Optional<Card> newMainCard = repository.findFirstByCustomer_Id(card.getCustomer().getId());
        if(newMainCard.isPresent()){
            newMainCard.get().setMainCard(true);
            repository.save(newMainCard.get());
        }
    }
}
