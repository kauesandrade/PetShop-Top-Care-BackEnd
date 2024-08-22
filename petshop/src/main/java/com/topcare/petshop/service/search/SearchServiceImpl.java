package com.topcare.petshop.service.search;

import com.topcare.petshop.entity.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@AllArgsConstructor
public class SearchServiceImpl implements SearchServiceInt {

    @Override
    public List<Product> searchProducts(List<Product> productList, String searchValue) {

        List<Product> productsSearch = new ArrayList<>();
        String convertString = convertString(searchValue);

        for (Product product : productList){

            String infoProduct = (product.getTitle() + " " + product.getCode());

            for (ProductVariant productVariant : product.getVariants()){
                infoProduct += " " + productVariant.getVariantTitle();
            }

            if(infoProduct.toLowerCase()
                    .contains(convertString)){
                productsSearch.add(product);
            }
        }

        return productsSearch;
    }

    @Override
    public List<Schedule> searchSchedules(List<Schedule> scheduleList, String searchValue) {

        List<Schedule> schedulesSearch = new ArrayList<>();
        String convertString = convertString(searchValue);

        for (Schedule schedule : scheduleList) {

            String infoSchedule = (schedule.getId().toString() + " " + schedule.getPet().getName()
                    + " " + schedule.getCustomer().getFullname());

            if (infoSchedule.toLowerCase()
                    .contains(convertString)) {
                schedulesSearch.add(schedule);
            }
        }

        return schedulesSearch;
    }

    @Override
    public List<com.topcare.petshop.entity.Service> searchServices(List<com.topcare.petshop.entity.Service> serviceList, String searchValue) {

        List<com.topcare.petshop.entity.Service> serviceSearch = new ArrayList<>();
        String convertString = convertString(searchValue);

        for (com.topcare.petshop.entity.Service service : serviceList) {

            String infoSchedule = (service.getCode() + " " + service.getTitle() + " " +
                    service.getCategory().getTitle());

            if (infoSchedule.toLowerCase()
                    .contains(convertString)) {
                serviceSearch.add(service);
            }
        }

        return serviceSearch;
    }

    @Override
    public List<CustomerOrder> searchCustomerOrder(List<CustomerOrder> customerOrderList, String searchValue) {

        List<CustomerOrder> customerOrderSearch = new ArrayList<>();
        String convertString = convertString(searchValue);

        for (CustomerOrder customerOrder : customerOrderList) {

            String infoCustomerOrder = (customerOrder.getCode().toString() + " " + customerOrder.getShipping().getShippingStatus()
                    + " " + customerOrder.getCustomer().getFullname() + " " + customerOrder.getCustomer().getCpf());

            if (infoCustomerOrder.toLowerCase()
                    .contains(convertString)) {
                customerOrderSearch.add(customerOrder);
            }
        }

        return customerOrderSearch;
    }

    private String convertString(String searchValue){
        return searchValue.toLowerCase().replaceAll("-"," ");
    }

}
