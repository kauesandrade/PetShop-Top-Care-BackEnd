package com.topcare.petshop.service.search;

import com.topcare.petshop.entity.OrderItem;
import com.topcare.petshop.entity.Product;
import com.topcare.petshop.entity.Schedule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@AllArgsConstructor
public class SearchServiceImpl implements SearchServiceInt {

    //    private final ProductRepository productRespository;


    @Override
    public List<Product> searchProducts(List<Product> productList, String searchValue) {


        List<Product> productsSearch = new ArrayList<>();
        String convertString = searchValue.toLowerCase().replaceAll("-"," ");

        for (Product product : productList){
            if(product.getTitle().toLowerCase()
                    .contains(convertString)){
                productsSearch.add(product);
            }
        }

        return productsSearch;
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
