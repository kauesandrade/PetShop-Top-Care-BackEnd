package com.topcare.petshop.service.orderBy;

import com.topcare.petshop.entity.OrderItem;
import com.topcare.petshop.entity.Product;
import com.topcare.petshop.entity.Schedule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderByServiceInt {

    List<Product> orderProductsBy(List<Product> productList, String string);
    List<Schedule> orderSchedulesBy(List<Schedule> scheduleList, String string);
    List<com.topcare.petshop.entity.Service> orderServicesBy(List<com.topcare.petshop.entity.Service> serviceList, String string);
    List<OrderItem> orderOrderItensBy(List<OrderItem> orderItemList, String string);
}
