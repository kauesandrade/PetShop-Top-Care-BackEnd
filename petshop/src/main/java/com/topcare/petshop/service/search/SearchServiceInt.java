package com.topcare.petshop.service.search;

import com.topcare.petshop.entity.*;
import org.hibernate.query.Page;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Interface para os serviços de busca para várias entidades.
 * Define métodos para buscar produtos, agendamentos, serviços e pedidos de clientes.
 */
@Service
public interface SearchServiceInt {

    /**
     * Busca produtos em uma lista com base no valor de pesquisa fornecido.
     *
     * @param productList Lista de produtos a ser pesquisada.
     * @param searchValue Valor de pesquisa a ser utilizado.
     * @return Lista de produtos que correspondem ao valor de pesquisa.
     */
    List<Product> searchProducts(List<Product> productList, String searchValue);

    /**
     * Busca agendamentos em uma lista com base no valor de pesquisa fornecido.
     *
     * @param scheduleList Lista de agendamentos a ser pesquisada.
     * @param searchValue Valor de pesquisa a ser utilizado.
     * @return Lista de agendamentos que correspondem ao valor de pesquisa.
     */
    List<Schedule> searchSchedules(List<Schedule> scheduleList, String searchValue);

    /**
     * Busca serviços em uma lista com base no valor de pesquisa fornecido.
     *
     * @param serviceList Lista de serviços a ser pesquisada.
     * @param searchValue Valor de pesquisa a ser utilizado.
     * @return Lista de serviços que correspondem ao valor de pesquisa.
     */
    List<com.topcare.petshop.entity.Service> searchServices(List<com.topcare.petshop.entity.Service> serviceList, String searchValue);

    /**
     * Busca pedidos de clientes em uma lista com base no valor de pesquisa fornecido.
     *
     * @param customerOrderList Lista de pedidos de clientes a ser pesquisada.
     * @param searchValue Valor de pesquisa a ser utilizado.
     * @return Lista de pedidos de clientes que correspondem ao valor de pesquisa.
     */
    List<CustomerOrder> searchCustomerOrder(List<CustomerOrder> customerOrderList, String searchValue);
}
