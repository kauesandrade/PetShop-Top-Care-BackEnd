package com.topcare.petshop.service.search;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SearchServiceImpl {

    private final ProductRepository productRespository;
    private final ServiceRepository serviceRepository;
    private final OrderRepository orderRepository;
    private final CustomerOrderRepository customerOrderRepository;



}
