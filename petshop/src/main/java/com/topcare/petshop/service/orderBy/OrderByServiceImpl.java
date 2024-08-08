package com.topcare.petshop.service.orderBy;

import com.topcare.petshop.entity.OrderItem;
import com.topcare.petshop.entity.Product;
import com.topcare.petshop.entity.Schedule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderByServiceImpl implements OrderByServiceInt {

    @Override
    public List<Product> orderProductsBy(List<Product> productList, String string) {
        return null;
    }

    @Override
    public List<Schedule> orderSchedulesBy(List<Schedule> scheduleList, String string) {
        return null;
    }

    @Override
    public List<com.topcare.petshop.entity.Service> orderServicesBy(List<com.topcare.petshop.entity.Service> serviceList, String string) {
        return null;
    }

    @Override
    public List<OrderItem> orderOrderItensBy(List<OrderItem> orderItemList, String string) {
        return null;
    }
}
