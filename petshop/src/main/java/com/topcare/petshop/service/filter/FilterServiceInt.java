package com.topcare.petshop.service.filter;

import com.topcare.petshop.entity.OrderItem;
import com.topcare.petshop.entity.Product;
import com.topcare.petshop.entity.ProductCategory;
import com.topcare.petshop.entity.Schedule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FilterServiceInt {

    List<Product> filterProducts(List<Product> productList, List<ProductCategory> productCategoryList);


//    List<Schedule> filterSchedules(List<Schedule> scheduleList, List<String> categoryList);
//    List<Service> filterServices(List<Service> serviceList, List<String> categoryList);
//    List<OrderItem> filterOrderItens(List<OrderItem> orderItemList, List<String> categoryList);
}
