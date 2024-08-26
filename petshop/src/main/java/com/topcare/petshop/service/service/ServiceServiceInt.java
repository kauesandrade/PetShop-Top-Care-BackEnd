package com.topcare.petshop.service.service;

import com.topcare.petshop.controller.dto.search.SearchRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Interface para os serviços relacionados à entidade {@link com.topcare.petshop.entity.Service}.
 * Define métodos para busca e ordenação de serviços com base em critérios de pesquisa.
 */
@Service
public interface ServiceServiceInt {

    /**
     * Busca serviços com base nos critérios fornecidos no DTO de pesquisa e aplica ordenação.
     *
     * @param searchRequestDTO DTO contendo os critérios de pesquisa.
     * @return Página de serviços encontrados e ordenados.
     */
    Page<com.topcare.petshop.entity.Service> searchService(SearchRequestDTO searchRequestDTO);
}
