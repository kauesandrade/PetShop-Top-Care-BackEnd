package com.topcare.petshop.service.search;

import com.topcare.petshop.entity.*;
import org.hibernate.query.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SearchServiceInt {

    List<Product> searchProducts (List<Product> productList, String searchValue);
    List<Schedule> searchSchedules(List<Schedule> scheduleList, String searchValue);
    List<com.topcare.petshop.entity.Service> searchServices(List<com.topcare.petshop.entity.Service> serviceList, String searchValue);
    List<CustomerOrder> searchCustomerOrder(List<CustomerOrder> customerOrderList, String searchValue);
}
