package com.topcare.petshop.service.sortBy;

import com.topcare.petshop.controller.dto.search.SearchResquestDTO;
import com.topcare.petshop.entity.OrderItem;
import com.topcare.petshop.entity.Product;
import com.topcare.petshop.entity.Schedule;
import com.topcare.petshop.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SortByServiceImpl implements SortByServiceInt {

//    private final ProductServiceImpl productService;
    private final ProductRepository productRepository;

    @Override
    public Page<Product> sortProductsBy(List<Product> productList, SearchResquestDTO searchRequestDTO) {

        Pageable pageable = PageRequest.of(searchRequestDTO.page(), searchRequestDTO.size(), convertSortBy(searchRequestDTO.sortBy()));

        return productRepository.findAllByIdIn(productList.stream().map(Product::getId).toList(), pageable);

    }

    @Override
    public Page<Schedule> orderSchedulesBy(List<Schedule> scheduleList, String string) {
        return null;
    }

    @Override
    public Page<com.topcare.petshop.entity.Service> sortServicesBy(List<com.topcare.petshop.entity.Service> serviceList, String string) {
        return null;
    }

    @Override
    public Page<OrderItem> sortOrderItensBy(List<OrderItem> orderItemList, String string) {
        return null;
    }


    private Sort convertSortBy(String valueInput){

        switch (valueInput){
            case "Popularidade" -> {
                return Sort.by("rating").ascending();
            }
            case "Maior Preço" ->{
                return Sort.by("price").ascending();
            }
            case "Menor Preço" ->{
                return Sort.by("price").descending();
            }
            case "Maiores Descontos" ->{
                return Sort.by("price").descending();
            }
            case "Nome (A-Z)" ->{
                return Sort.by("title").ascending();
            }
            case "Nome (Z-A)" ->{
                return Sort.by("title").descending();
            }
            default -> {
                return Sort.by("rating").ascending();
            }
        }
    }
}
