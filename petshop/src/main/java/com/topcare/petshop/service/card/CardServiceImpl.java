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
    public CardResponseDTO getCardToDTO(Long id) throws Exception {
        Optional<Card> optCard = repository.findById(id);

        if (optCard.isEmpty()) {
            throw new Exception("Cartão não encontrado");
        }

        return optCard.get().toDTO();
    }

    @Override
    public Card getCard(Long id) throws Exception {
        Optional<Card> optCard = repository.findById(id);

        if (optCard.isEmpty()) {
            throw new Exception("Cartão não encontrado");
        }
        return optCard.get();
    }

    @Override
    public List<CardResponseDTO> getAllCards() {
        return repository.findAll().stream().map(Card::toDTO).toList();
    }

    @Override
    public List<Card> getCardsOfUser(Long userId) {
        return repository.findByCustomer_Id(userId);
    }

    @Override
    public List<CardResponseDTO> getCardsOfUserToDTO(Long userId) {
        return getCardsOfUser(userId).stream().map(Card::toDTO).toList();
    }

    @Override
    public CardResponseDTO registerCard(CardRequestDTO dto) throws Exception {
        Card newCard = new Card(dto);

        Customer customer = customerService.getCustomer(dto.userId());
        List<Card> cards = customer.getCards();

        if (cards.isEmpty()){
            newCard.setMainCard(true);
        } else if (!dto.mainCard()){
            newCard.setMainCard(false);
        } else {
            Card oldCard = repository.findByCustomer_IdAndMainCardIsTrue(dto.userId()).get();
            newCard.setMainCard(true);
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
        Card card = getCard(id);
        card.edit(dto);

        Customer customer = customerService.getCustomer(dto.userId());

        Card oldCard = repository.findByCustomer_IdAndMainCardIsTrue(dto.userId()).get();

        if (dto.mainCard() && !Objects.equals(card.getId(), oldCard.getId())){
            oldCard.setMainCard(false);
        } else if (!dto.mainCard() && card.getMainCard()) {
            card.setMainCard(false);
            Optional<Card> newMainCard = repository.findFirstByCustomer_Id(card.getCustomer().getId());
            newMainCard.ifPresent(value -> value.setMainCard(true));
        }

        customerService.saveCustomer(customer);

        return card.toDTO();
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
            Card mainCard = newMainCard.get();
            mainCard.setMainCard(true);
            repository.save(mainCard);
        }
    }
}
