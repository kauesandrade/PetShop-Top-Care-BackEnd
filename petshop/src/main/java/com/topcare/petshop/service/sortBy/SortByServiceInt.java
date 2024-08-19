package com.topcare.petshop.service.sortBy;

import com.topcare.petshop.controller.dto.search.SearchRequestDTO;
import com.topcare.petshop.entity.OrderItem;
import com.topcare.petshop.entity.Product;
import com.topcare.petshop.entity.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SortByServiceInt {

    Page<Product> sortProductsBy(List<Product> productList, SearchRequestDTO searchRequestDTO);
    Page<Schedule> orderSchedulesBy(List<Schedule> scheduleList, SearchRequestDTO searchRequestDTO);
    Page<com.topcare.petshop.entity.Service> sortServicesBy(List<com.topcare.petshop.entity.Service> serviceList, SearchRequestDTO searchRequestDTO);
    Page<OrderItem> sortOrderItensBy(List<OrderItem> orderItemList, SearchRequestDTO searchRequestDTO);
}

