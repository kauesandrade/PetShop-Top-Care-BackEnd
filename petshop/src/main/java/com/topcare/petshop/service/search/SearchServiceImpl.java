package com.topcare.petshop.service.search;

import com.topcare.petshop.entity.OrderItem;
import com.topcare.petshop.entity.Product;
import com.topcare.petshop.entity.Schedule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SearchServiceImpl implements SearchServiceInt {

    //    private final ProductRepository productRespository;
//    private final ServiceRepository serviceRepository;
//    private final OrderRepository orderRepository;
//    private final CustomerOrderRepository customerOrderRepository;


    @Override
    public List<Product> searchProducts(List<Product> productList, String searchValue) {
        return null;
    }

    @Override
    public List<Schedule> searchSchedules(List<Schedule> scheduleList, String searchValue) {
        return null;
    }

    @Override
    public List<com.topcare.petshop.entity.Service> searchServices(List<com.topcare.petshop.entity.Service> serviceList, String searchValue) {
        return null;
    }

    @Override
    public List<OrderItem> searchOrderItens(List<OrderItem> orderItemList, String searchValue) {

        return null;
    }




}
