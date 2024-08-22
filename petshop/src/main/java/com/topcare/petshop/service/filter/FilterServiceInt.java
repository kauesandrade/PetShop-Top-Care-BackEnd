package com.topcare.petshop.service.filter;

import com.topcare.petshop.entity.OrderItem;
import com.topcare.petshop.entity.Product;
import com.topcare.petshop.entity.ProductCategory;
import com.topcare.petshop.entity.Schedule;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Interface para os serviços relacionados ao filtro de produtos.
 * Define métodos para filtrar produtos com base em categorias.
 */
@Service
public interface FilterServiceInt {

    /**
     * Filtra produtos com base em uma lista de IDs de categorias.
     * Se a lista de categorias estiver vazia, retorna todos os produtos.
     *
     * @param productCategoryList Lista de IDs de categorias.
     * @return Lista de produtos filtrados.
     */
    List<Product> filterProducts(List<Long> productCategoryList);

    // Métodos adicionais para filtrar outras entidades podem ser adicionados aqui
    // List<Schedule> filterSchedules(List<Schedule> scheduleList, List<String> categoryList);
    // List<Service> filterServices(List<Service> serviceList, List<String> categoryList);
    // List<OrderItem> filterOrderItens(List<OrderItem> orderItemList, List<String> categoryList);
}
