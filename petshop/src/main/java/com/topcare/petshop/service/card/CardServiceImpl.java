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
/**
 * Implementa os serviços relacionados à entidade {@link Card}.
 * Fornece métodos para manipulação de cartões, incluindo criação, leitura, atualização e exclusão.
 */
@Service
@AllArgsConstructor
public class CardServiceImpl implements CardServiceInt {

    private final CardRepository repository;
    private final CustomerServiceImpl customerService;

    /**
     * Retorna um DTO do cartão com o ID fornecido.
     *
     * @param id ID do cartão.
     * @return DTO do cartão.
     * @throws Exception Se o cartão não for encontrado.
     */
    @Override
    public CardResponseDTO getCardToDTO(Long id) throws Exception {
        Optional<Card> optCard = repository.findById(id);

        if (optCard.isEmpty()) {
            throw new Exception("Cartão não encontrado");
        }

        return optCard.get().toDTO();
    }

    /**
     * Retorna o cartão com o ID fornecido.
     *
     * @param id ID do cartão.
     * @return Cartão encontrado.
     * @throws Exception Se o cartão não for encontrado.
     */
    @Override
    public Card getCard(Long id) throws Exception {
        Optional<Card> optCard = repository.findById(id);

        if (optCard.isEmpty()) {
            throw new Exception("Cartão não encontrado");
        }
        return optCard.get();
    }

    /**
     * Retorna uma lista de todos os cartões convertidos para DTOs.
     *
     * @return Lista de DTOs de cartões.
     */
    @Override
    public List<CardResponseDTO> getAllCards() {
        return repository.findAll().stream().map(Card::toDTO).toList();
    }

    /**
     * Registra um novo cartão com base no DTO fornecido.
     * Define o cartão como principal se não houver cartões ou se o DTO indicar isso.
     * Atualiza o cartão principal existente, se necessário.
     *
     * @param dto DTO do cartão a ser registrado.
     * @return DTO do cartão registrado.
     * @throws Exception Se o cliente não for encontrado ou ocorrer um erro.
     */
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

    /**
     * Edita um cartão existente com base no ID e no DTO fornecidos.
     * Atualiza o cartão principal, se necessário.
     *
     * @param id ID do cartão a ser editado.
     * @param dto DTO com as novas informações.
     * @return DTO do cartão editado.
     * @throws Exception Se o cartão não for encontrado ou ocorrer um erro.
     */
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

    /**
     * Exclui um cartão pelo ID.
     * Atualiza o cartão principal do cliente se necessário.
     *
     * @param id ID do cartão a ser excluído.
     * @throws Exception Se o cartão não for encontrado ou ocorrer um erro.
     */
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
