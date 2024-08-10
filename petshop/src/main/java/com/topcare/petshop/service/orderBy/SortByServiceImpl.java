package com.topcare.petshop.service.orderBy;

import com.topcare.petshop.entity.OrderItem;
import com.topcare.petshop.entity.Product;
import com.topcare.petshop.entity.Schedule;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SortByServiceImpl implements SortByServiceInt {

    @Override
    public Page<Product> sortProductsBy(List<Product> productList, String sortBy, Integer page) {

//        Pageable pageable = PageRequest.of(0,2, Sort.by("price"));

//        Page<Product> productPage = (Page<Product>) productList;


        Pageable pageable = PageRequest.of(page, 10, Sort.by("title").descending());
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), productList.size());

        List<Product> subList = productList.subList(start, end);

        return new PageImpl<>(subList, pageable, productList.size());
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
}
