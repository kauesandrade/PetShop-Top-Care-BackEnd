package com.topcare.petshop.service.sortBy;
import com.topcare.petshop.controller.dto.search.SearchRequestDTO;
import com.topcare.petshop.entity.OrderItem;
import com.topcare.petshop.entity.Product;
import com.topcare.petshop.entity.Schedule;
import com.topcare.petshop.repository.ProductRepository;
import com.topcare.petshop.repository.ServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 * Implementa serviços de ordenação para várias entidades.
 * Fornece métodos para ordenar produtos, agendamentos, serviços e itens de pedido com base em critérios fornecidos.
 */
@Service
@AllArgsConstructor
public class SortByServiceImpl implements SortByServiceInt {

    private final ProductRepository productRepository;
    private final ServiceRepository serviceRepository;

    /**
     * Ordena produtos em uma lista com base nos critérios fornecidos no DTO de pesquisa.
     *
     * @param productList Lista de produtos a ser ordenada.
     * @param searchRequestDTO DTO contendo os critérios de ordenação e paginação.
     * @return Página de produtos ordenados.
     */
    @Override
    public Page<Product> sortProductsBy(List<Product> productList, SearchRequestDTO searchRequestDTO) {
        Pageable pageable = PageRequest.of(searchRequestDTO.page(), searchRequestDTO.size(), convertSortBy(searchRequestDTO.sortBy()));
        Page<Product> productPage = productRepository.findAllByIdIn(productList.stream().map(Product::getId).toList(), pageable);
        return convertAndSortByProductToPage(searchRequestDTO.sortBy(), productPage, pageable);
    }

    /**
     * Ordena agendamentos em uma lista com base nos critérios fornecidos no DTO de pesquisa.
     *
     * @param scheduleList Lista de agendamentos a ser ordenada.
     * @param searchRequestDTO DTO contendo os critérios de ordenação e paginação.
     * @return Página de agendamentos ordenados.
     */
    @Override
    public Page<Schedule> orderSchedulesBy(List<Schedule> scheduleList, SearchRequestDTO searchRequestDTO) {
        // Implementação a ser fornecida
        return null;
    }

    /**
     * Ordena serviços em uma lista com base nos critérios fornecidos no DTO de pesquisa.
     *
     * @param serviceList Lista de serviços a ser ordenada.
     * @param searchRequestDTO DTO contendo os critérios de ordenação e paginação.
     * @return Página de serviços ordenados.
     */
    @Override
    public Page<com.topcare.petshop.entity.Service> sortServicesBy(List<com.topcare.petshop.entity.Service> serviceList, SearchRequestDTO searchRequestDTO) {
        Pageable pageable = PageRequest.of(searchRequestDTO.page(), searchRequestDTO.size(), convertSortBy(searchRequestDTO.sortBy()));
        return serviceRepository.findAllByIdIn(serviceList.stream().map(com.topcare.petshop.entity.Service::getId).toList(), pageable);
    }

    /**
     * Ordena itens de pedido em uma lista com base nos critérios fornecidos no DTO de pesquisa.
     *
     * @param orderItemList Lista de itens de pedido a ser ordenada.
     * @param searchRequestDTO DTO contendo os critérios de ordenação e paginação.
     * @return Página de itens de pedido ordenados.
     */
    @Override
    public Page<OrderItem> sortOrderItensBy(List<OrderItem> orderItemList, SearchRequestDTO searchRequestDTO) {
        // Implementação a ser fornecida
        return null;
    }

    /**
     * Converte e ordena produtos em uma página com base no critério de ordenação fornecido.
     *
     * @param sortByValue Valor do critério de ordenação.
     * @param page Página de produtos a ser ordenada.
     * @param pageable Informações de paginação.
     * @return Página de produtos ordenados.
     */
    private Page<Product> convertAndSortByProductToPage(String sortByValue, Page<Product> page, Pageable pageable) {
        List<Product> sortedProducts = new ArrayList<>();

        switch (sortByValue) {
            case "Maior Preço" -> {
                sortedProducts = page.stream()
                        .sorted(Comparator.comparing(p -> p.getVariants().getFirst().getPrice())).toList().reversed();
            }
            case "Menor Preço" -> {
                sortedProducts = page.stream()
                        .sorted(Comparator.comparing(p -> p.getVariants().getFirst().getPrice())).toList();
            }
            case "Maiores Descontos" -> {
                sortedProducts = page.stream()
                        .sorted(Comparator.comparing(p -> p.getVariants().getFirst().getDiscount())).toList().reversed();
            }
            case "Maior Estoque" -> {
                sortedProducts = page.stream()
                        .sorted(Comparator.comparing(p -> p.getVariants().getFirst().getStock())).toList().reversed();
            }
            case "Menor Estoque" -> {
                sortedProducts = page.stream()
                        .sorted(Comparator.comparing(p -> p.getVariants().getFirst().getStock())).toList();
            }
            default -> {
                return page;
            }
        }
        return new PageImpl<>(sortedProducts, pageable, page.getTotalElements());
    }

    /**
     * Converte o critério de ordenação em um objeto {@link Sort}.
     *
     * @param sortByValue Valor do critério de ordenação.
     * @return Objeto {@link Sort} configurado.
     */
    private Sort convertSortBy(String sortByValue){

        switch (sortByValue){
            case "Popularidade" -> {
                return Sort.by("rating").ascending();
            }
            case "Nome (A-Z)" -> {
                return Sort.by("title").ascending();
            }
            case "Nome (Z-A)" -> {
                return Sort.by("title").descending();
            }
            default -> {
                return Sort.by("title").ascending();
            }
        }
    }
}

