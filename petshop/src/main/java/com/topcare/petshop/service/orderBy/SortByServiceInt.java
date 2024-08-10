package com.topcare.petshop.service.orderBy;

import com.topcare.petshop.entity.OrderItem;
import com.topcare.petshop.entity.Product;
import com.topcare.petshop.entity.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SortByServiceInt {

    Page<Product> sortProductsBy(List<Product> productList, String sortBy, Integer page);
    Page<Schedule> orderSchedulesBy(List<Schedule> scheduleList, String string);
    Page<com.topcare.petshop.entity.Service> sortServicesBy(List<com.topcare.petshop.entity.Service> serviceList, String string);
    Page<OrderItem> sortOrderItensBy(List<OrderItem> orderItemList, String string);
}

