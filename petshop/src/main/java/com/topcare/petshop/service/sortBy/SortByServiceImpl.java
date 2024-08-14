package com.topcare.petshop.service.sortBy;

import com.topcare.petshop.controller.dto.SearchResquestDTO;
import com.topcare.petshop.entity.OrderItem;
import com.topcare.petshop.entity.Product;
import com.topcare.petshop.entity.Schedule;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SortByServiceImpl implements SortByServiceInt {

    @Override
    public Page<Product> sortProductsBy(List<Product> productList, SearchResquestDTO searchRequestDTO) {

        Sort.Order order = convertSortBy(searchRequestDTO.sortBy()).iterator().next();
        Comparator<Product> comparator = (o1, o2) -> {
            try {
                Field field = Product.class.getDeclaredField(order.getProperty());
                field.setAccessible(true);

                Object value1 = field.get(o1);
                Object value2 = field.get(o2);
                field.setAccessible(false);

                if (value1 instanceof Comparable && value2 instanceof Comparable) {
                    return order.isAscending()
                            ? ((Comparable) value1).compareTo(value2)
                            : ((Comparable) value2).compareTo(value1);
                } else {
                    System.out.println("Se não for comparável, considera igual");
                    return 0;
                }
            } catch (Exception e) {
                System.out.println("Erro ao acessar o atributo: " + e.getMessage());
                return 0;
            }
        };

        Pageable pageable = PageRequest.of(searchRequestDTO.page(), searchRequestDTO.size(), convertSortBy(searchRequestDTO.sortBy()));

        List<Product> listaOrdenada = productList.stream()
                .sorted(comparator)
                .collect(Collectors.toList());

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), listaOrdenada.size());

        return new PageImpl<>(listaOrdenada.subList(start, end), pageable, listaOrdenada.size());
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


    private Sort convertSortBy(String valueInput){

        switch (valueInput){
            case "Popularidade" -> {
                return Sort.by("rating").ascending();
            }
            case "Maior Preço" ->{
                return Sort.by("price").ascending();
            }
            case "Menor Preço" ->{
                return Sort.by("price").descending();
            }
            case "Maiores Descontos" ->{
                return Sort.by("price").descending();
            }
            case "Nome (A-Z)" ->{
                return Sort.by("title").ascending();
            }
            case "Nome (Z-A)" ->{
                return Sort.by("title").descending();
            }
        }
        return null;
    }
}
