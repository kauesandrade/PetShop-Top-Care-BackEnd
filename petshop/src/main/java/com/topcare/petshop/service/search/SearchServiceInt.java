package com.topcare.petshop.service.search;

import com.topcare.petshop.entity.OrderItem;
import com.topcare.petshop.entity.Product;
import com.topcare.petshop.entity.ProductVariant;
import com.topcare.petshop.entity.Schedule;
import org.hibernate.query.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SearchServiceInt {

    List<Product> searchProducts (List<Product> productList, String searchValue);
    List<Schedule> searchSchedules(List<Schedule> scheduleList, String searchValue);
    List<com.topcare.petshop.entity.Service> searchServices(List<com.topcare.petshop.entity.Service> serviceList, String searchValue);
    List<OrderItem> searchOrderItens(List<OrderItem> orderItemList, String searchValue);

}
