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

@Service
@AllArgsConstructor
public class SortByServiceImpl implements SortByServiceInt {

    private final ProductRepository productRepository;
    private final ServiceRepository serviceRepository;

    @Override
    public Page<Product> sortProductsBy(List<Product> productList, SearchRequestDTO searchRequestDTO) {

        Pageable pageable = PageRequest.of(searchRequestDTO.page(), searchRequestDTO.size(), convertSortBy(searchRequestDTO.sortBy()));
        Page<Product> productPage = productRepository.findAllByIdIn(productList.stream().map(Product::getId).toList(), pageable);
        return convertAndSortByProductToPage(searchRequestDTO.sortBy(), productPage, pageable);

    }

    @Override
    public Page<Schedule> orderSchedulesBy(List<Schedule> scheduleList, SearchRequestDTO searchRequestDTO) {
        return null;
    }

    @Override
    public Page<com.topcare.petshop.entity.Service> sortServicesBy(List<com.topcare.petshop.entity.Service> serviceList, SearchRequestDTO searchRequestDTO) {
        Pageable pageable = PageRequest.of(searchRequestDTO.page(), searchRequestDTO.size(), convertSortBy(searchRequestDTO.sortBy()));

        return serviceRepository.findAllByIdIn(serviceList.stream()
                .map(com.topcare.petshop.entity.Service::getId).toList(), pageable);
    }

    @Override
    public Page<OrderItem> sortOrderItensBy(List<OrderItem> orderItemList, SearchRequestDTO searchRequestDTO) {
        return null;
    }

    private Page<Product> convertAndSortByProductToPage(String sortByValue, Page<Product> page, Pageable pageable){

        List<Product> sortedProducts = new ArrayList<>();

        switch (sortByValue){
            case "Maior Preço" ->{
                sortedProducts = page.stream()
                        .sorted(Comparator.comparing(p -> p.getVariants().getFirst().getPrice())).toList().reversed();
            }
            case "Menor Preço" ->{
                sortedProducts = page.stream()
                        .sorted(Comparator.comparing(p -> p.getVariants().getFirst().getPrice())).toList();
            }
            case "Maiores Descontos" ->{
                sortedProducts = page.stream()
                        .sorted(Comparator.comparing(p -> p.getVariants().getFirst().getDiscount())).toList().reversed();
            }
            case "Maior Estoque" ->{
                sortedProducts = page.stream()
                        .sorted(Comparator.comparing(p -> p.getVariants().getFirst().getStock())).toList().reversed();
            }
            case "Menor Estoque" ->{
                sortedProducts = page.stream()
                        .sorted(Comparator.comparing(p -> p.getVariants().getFirst().getStock())).toList();
            }
            default -> {
                return page;
            }
        }
        return new PageImpl<>(sortedProducts, pageable, page.getTotalElements());
    }


    private Sort convertSortBy(String sortByValue){

        switch (sortByValue){
            case "Popularidade" -> {
                return Sort.by("rating").ascending();
            }
            case "Nome (A-Z)" ->{
                return Sort.by("title").ascending();
            }
            case "Nome (Z-A)" ->{
                return Sort.by("title").descending();
            }
            default -> {
                return Sort.by("title").ascending();
            }
        }
    }
}
