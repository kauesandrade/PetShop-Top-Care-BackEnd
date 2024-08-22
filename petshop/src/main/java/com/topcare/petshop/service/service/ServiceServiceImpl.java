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

@Service
@AllArgsConstructor
public class ServiceServiceImpl implements ServiceServiceInt{

    private final ServiceRepository repository;
    private final SearchServiceImpl searchService;
    private final SortByServiceImpl sortByService;


    @Override
    public Page<com.topcare.petshop.entity.Service> searchService(SearchRequestDTO searchResquestDTO) {
        List<com.topcare.petshop.entity.Service> serviceList = new ArrayList<>();
        Page<com.topcare.petshop.entity.Service> servicePage;

        serviceList = searchService.searchServices(repository.findAll(), searchResquestDTO.searchValue());
        servicePage = sortByService.sortServicesBy(serviceList, searchResquestDTO);
        return servicePage;
    }
}
