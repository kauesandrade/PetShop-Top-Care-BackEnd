package com.topcare.petshop.service.card;

import com.topcare.petshop.controller.dto.card.CardRequestDTO;
import com.topcare.petshop.controller.dto.card.CardResponseDTO;
import com.topcare.petshop.entity.Card;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Interface para os serviços relacionados à entidade {@link Card}.
 * Define os métodos para manipulação de cartões, incluindo criação, leitura, atualização e exclusão.
 */
@Service
public interface CardServiceInt {

    /**
     * Retorna um DTO do cartão com o ID fornecido.
     *
     * @param id ID do cartão.
     * @return DTO do cartão.
     * @throws Exception Se o cartão não for encontrado.
     */
    CardResponseDTO getCardToDTO(Long id) throws Exception;

    /**
     * Retorna o cartão com o ID fornecido.
     *
     * @param id ID do cartão.
     * @return Cartão encontrado.
     * @throws Exception Se o cartão não for encontrado.
     */
    Card getCard(Long id) throws Exception;

    /**
     * Retorna uma lista de todos os cartões convertidos para DTOs.
     *
     * @return Lista de DTOs de cartões.
     */
    List<CardResponseDTO> getAllCards();

    /**
     * Registra um novo cartão com base no DTO fornecido.
     * Define o cartão como principal se não houver cartões ou se o DTO indicar isso.
     * Atualiza o cartão principal existente, se necessário.
     *
     * @param dto DTO do cartão a ser registrado.
     * @return DTO do cartão registrado.
     * @throws Exception Se o cliente não for encontrado ou ocorrer um erro.
     */
    CardResponseDTO registerCard(CardRequestDTO dto) throws Exception;

    /**
     * Edita um cartão existente com base no ID e no DTO fornecidos.
     * Atualiza o cartão principal, se necessário.
     *
     * @param id ID do cartão a ser editado.
     * @param dto DTO com as novas informações.
     * @return DTO do cartão editado.
     * @throws Exception Se o cartão não for encontrado ou ocorrer um erro.
     */
    CardResponseDTO editCard(Long id, CardRequestDTO dto) throws Exception;

    /**
     * Exclui um cartão pelo ID.
     * Atualiza o cartão principal do cliente se necessário.
     *
     * @param id ID do cartão a ser excluído.
     * @throws Exception Se o cartão não for encontrado ou ocorrer um erro.
     */
    void deleteCard(Long id) throws Exception;
}
