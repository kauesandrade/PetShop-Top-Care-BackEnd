package com.topcare.petshop.service.service;

import com.topcare.petshop.controller.dto.search.SearchRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceServiceInt {

    Page<com.topcare.petshop.entity.Service> searchService(SearchRequestDTO searchResquestDTO);

}
