package com.topcare.petshop.service.sortBy;

import com.topcare.petshop.controller.dto.search.SearchRequestDTO;
import com.topcare.petshop.entity.OrderItem;
import com.topcare.petshop.entity.Product;
import com.topcare.petshop.entity.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Interface para serviços de ordenação para várias entidades.
 * Define métodos para ordenar produtos, agendamentos, serviços e itens de pedido com base em critérios fornecidos.
 */
@Service
public interface SortByServiceInt {

    /**
     * Ordena produtos em uma lista com base nos critérios fornecidos no DTO de pesquisa.
     *
     * @param productList Lista de produtos a ser ordenada.
     * @param searchRequestDTO DTO contendo os critérios de ordenação e paginação.
     * @return Página de produtos ordenados.
     */
    Page<Product> sortProductsBy(List<Product> productList, SearchRequestDTO searchRequestDTO);

    /**
     * Ordena agendamentos em uma lista com base nos critérios fornecidos no DTO de pesquisa.
     *
     * @param scheduleList Lista de agendamentos a ser ordenada.
     * @param searchRequestDTO DTO contendo os critérios de ordenação e paginação.
     * @return Página de agendamentos ordenados.
     */
    Page<Schedule> orderSchedulesBy(List<Schedule> scheduleList, SearchRequestDTO searchRequestDTO);

    /**
     * Ordena serviços em uma lista com base nos critérios fornecidos no DTO de pesquisa.
     *
     * @param serviceList Lista de serviços a ser ordenada.
     * @param searchRequestDTO DTO contendo os critérios de ordenação e paginação.
     * @return Página de serviços ordenados.
     */
    Page<com.topcare.petshop.entity.Service> sortServicesBy(List<com.topcare.petshop.entity.Service> serviceList, SearchRequestDTO searchRequestDTO);

    /**
     * Ordena itens de pedido em uma lista com base nos critérios fornecidos no DTO de pesquisa.
     *
     * @param orderItemList Lista de itens de pedido a ser ordenada.
     * @param searchRequestDTO DTO contendo os critérios de ordenação e paginação.
     * @return Página de itens de pedido ordenados.
     */
    Page<OrderItem> sortOrderItensBy(List<OrderItem> orderItemList, SearchRequestDTO searchRequestDTO);
}
