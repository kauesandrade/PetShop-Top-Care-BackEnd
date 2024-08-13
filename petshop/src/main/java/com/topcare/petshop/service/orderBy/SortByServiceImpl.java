package com.topcare.petshop.service.orderBy;

import com.topcare.petshop.controller.dto.SearchResquestDTO;
import com.topcare.petshop.entity.OrderItem;
import com.topcare.petshop.entity.Product;
import com.topcare.petshop.entity.Schedule;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SortByServiceImpl implements SortByServiceInt {

    @Override
    public Page<Product> sortProductsBy(List<Product> productList, SearchResquestDTO searchResquestDTO) {

        Pageable pageable = PageRequest.of(searchResquestDTO.page(), searchResquestDTO.size(), Sort.by(searchResquestDTO.sortBy()));

        List<Product> sortedProducts = (List<Product>) productList.stream()
                .sorted(Comparator.comparing(product -> {
                    try {
                        return (Comparable) Product.class.getDeclaredField(searchResquestDTO.sortBy()).get(product);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        throw new RuntimeException("Erro ao ordenar a lista de produtos.", e);
                    }
                }))
                .collect(Collectors.toList());


        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), sortedProducts.size());


        List<Product> paginatedProducts = sortedProducts.subList(start, end);


        return new PageImpl<>(paginatedProducts, pageable, sortedProducts.size());
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
