package com.topcare.petshop.controller.dto.search;

/**
 * DTO para enviar uma solicitação de busca no sistema de pet shop.
 *
 * Campos:
 * - searchValue: Valor ou termo da busca.
 * - sortBy: Critério de ordenação dos resultados.
 * - page: Número da página atual para paginação.
 * - size: Número de itens por página.
 *
 * Anotações:
 * - @param searchValue: Termo ou valor a ser pesquisado.
 * - @param sortBy: Critério para ordenar os resultados da busca.
 * - @param page: Número da página para a busca paginada.
 * - @param size: Quantidade de itens a serem retornados por página.
 */
public record SearchRequestDTO(
        String searchValue,
        String sortBy,
        Integer page,
        Integer size
) {
}
