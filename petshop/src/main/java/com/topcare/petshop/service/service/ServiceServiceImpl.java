package com.topcare.petshop.service.service;

import com.topcare.petshop.controller.dto.search.SearchRequestDTO;
import com.topcare.petshop.repository.ServiceRepository;
import com.topcare.petshop.service.search.SearchServiceImpl;
import com.topcare.petshop.service.sortBy.SortByServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Implementa os serviços relacionados à entidade {@link com.topcare.petshop.entity.Service}.
 * Fornece métodos para busca de serviços com base em critérios de pesquisa e ordenação.
 */
@Service
@AllArgsConstructor
public class ServiceServiceImpl implements ServiceServiceInt {

    private final ServiceRepository repository;
    private final SearchServiceImpl searchService;
    private final SortByServiceImpl sortByService;

    /**
     * Busca serviços com base nos critérios fornecidos no DTO de pesquisa e aplica ordenação.
     *
     * @param searchRequestDTO DTO contendo os critérios de pesquisa.
     * @return Página de serviços encontrados e ordenados.
     */
    @Override
    public Page<com.topcare.petshop.entity.Service> searchService(SearchRequestDTO searchRequestDTO) {
        List<com.topcare.petshop.entity.Service> serviceList = new ArrayList<>();
        Page<com.topcare.petshop.entity.Service> servicePage;

        serviceList = searchService.searchServices(repository.findAll(), searchRequestDTO.searchValue());
        servicePage = sortByService.sortServicesBy(serviceList, searchRequestDTO);
        return servicePage;
    }
}
