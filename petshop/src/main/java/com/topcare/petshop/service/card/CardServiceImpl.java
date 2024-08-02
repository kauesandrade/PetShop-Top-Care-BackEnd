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

@Service
@AllArgsConstructor
public class CardServiceImpl implements CardServiceInt {

    private CardRepository repository;
    private CustomerServiceImpl customerService;

    @Override
    public Card getCard(Long id) {
        Card card = repository.findById(id).get();
        return card;
    }

    @Override
    public List<Card> getAllCards() {
        return repository.findAll();
    }

    @Override
    public CardResponseDTO registerCard(CardRequestDTO dto) throws Exception {
        Card newCard = new Card();
        newCard.setName(dto.name());
        newCard.setExpirationDate(dto.expirationDate());
        newCard.setLastDigits(dto.lastDigits());

        Card oldCard = customerService.getCustomerMainCard(dto.userId());

        Customer customer = customerService.getCustomer(dto.userId());

        List<Card> cards = customer.getCards();

        if (cards.isEmpty()){
            newCard.setMainCard(true);
        } else if (!dto.mainCard()){
            newCard.setMainCard(dto.mainCard());
        } else {
            newCard.setMainCard(dto.mainCard());
            int indexCard = cards.indexOf(oldCard);
            oldCard.setMainCard(false);
            cards.set(indexCard, oldCard);
        }
        cards.add(newCard);
        customerService.saveCustomer(customer);
        return newCard.toDto();
    }

    @Override
    public CardResponseDTO editCard(Long id, CardRequestDTO dto) throws Exception {
        Card newCard = getCard(id);
        newCard.setName(dto.name());
        newCard.setLastDigits(dto.lastDigits());
        newCard.setExpirationDate(dto.expirationDate());

        if (!dto.mainCard()){
            newCard.setMainCard(dto.mainCard());
            repository.save(newCard);
            return newCard.toDto();
        }

        Card oldCard = customerService.getCustomerMainCard(dto.userId());

        newCard.setMainCard(dto.mainCard());
        oldCard.setMainCard(false);
        repository.save(newCard);
        repository.save(oldCard);
        return newCard.toDto();
    }

    @Override
    public void deleteCard(Long id) throws Exception {
        if(!repository.existsById(id)){
            throw new Exception("Cartão não encontrado");
        }
        repository.deleteById(id);
    }
}
