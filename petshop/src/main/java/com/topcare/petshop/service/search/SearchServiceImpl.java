package com.topcare.petshop.service.search;

import com.topcare.petshop.entity.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/**
 * Implementa os serviços de busca para várias entidades.
 * Fornece métodos para buscar produtos, agendamentos, serviços e pedidos de clientes com base em um valor de pesquisa.
 */
@Service
@AllArgsConstructor
public class SearchServiceImpl implements SearchServiceInt {

    /**
     * Busca produtos em uma lista com base no valor de pesquisa fornecido.
     *
     * @param productList Lista de produtos a ser pesquisada.
     * @param searchValue Valor de pesquisa a ser utilizado.
     * @return Lista de produtos que correspondem ao valor de pesquisa.
     */
    @Override
    public List<Product> searchProducts(List<Product> productList, String searchValue) {
        List<Product> productsSearch = new ArrayList<>();
        String convertString = convertString(searchValue);

        for (Product product : productList){
            String infoProduct = (product.getTitle() + " " + product.getCode());

            for (ProductVariant productVariant : product.getVariants()){
                infoProduct += " " + productVariant.getVariantTitle();
            }

            if(infoProduct.toLowerCase().contains(convertString)){
                productsSearch.add(product);
            }
        }

        return productsSearch;
    }

    /**
     * Busca agendamentos em uma lista com base no valor de pesquisa fornecido.
     *
     * @param scheduleList Lista de agendamentos a ser pesquisada.
     * @param searchValue Valor de pesquisa a ser utilizado.
     * @return Lista de agendamentos que correspondem ao valor de pesquisa.
     */
    @Override
    public List<Schedule> searchSchedules(List<Schedule> scheduleList, String searchValue) {
        List<Schedule> schedulesSearch = new ArrayList<>();
        String convertString = convertString(searchValue);

        for (Schedule schedule : scheduleList) {
            String infoSchedule = (schedule.getId().toString() + " " + schedule.getPet().getName()
                    + " " + schedule.getCustomer().getFullname());

            if (infoSchedule.toLowerCase().contains(convertString)) {
                schedulesSearch.add(schedule);
            }
        }

        return schedulesSearch;
    }

    /**
     * Busca serviços em uma lista com base no valor de pesquisa fornecido.
     *
     * @param serviceList Lista de serviços a ser pesquisada.
     * @param searchValue Valor de pesquisa a ser utilizado.
     * @return Lista de serviços que correspondem ao valor de pesquisa.
     */
    @Override
    public List<com.topcare.petshop.entity.Service> searchServices(List<com.topcare.petshop.entity.Service> serviceList, String searchValue) {
        List<com.topcare.petshop.entity.Service> serviceSearch = new ArrayList<>();
        String convertString = convertString(searchValue);

        for (com.topcare.petshop.entity.Service service : serviceList) {
            String infoService = (service.getCode() + " " + service.getTitle() + " " +
                    service.getCategory().getTitle());

            if (infoService.toLowerCase().contains(convertString)) {
                serviceSearch.add(service);
            }
        }

        return serviceSearch;
    }

    /**
     * Busca pedidos de clientes em uma lista com base no valor de pesquisa fornecido.
     *
     * @param customerOrderList Lista de pedidos de clientes a ser pesquisada.
     * @param searchValue Valor de pesquisa a ser utilizado.
     * @return Lista de pedidos de clientes que correspondem ao valor de pesquisa.
     */
    @Override
    public List<CustomerOrder> searchCustomerOrder(List<CustomerOrder> customerOrderList, String searchValue) {
        List<CustomerOrder> customerOrderSearch = new ArrayList<>();
        String convertString = convertString(searchValue);

        for (CustomerOrder customerOrder : customerOrderList) {
            String infoCustomerOrder = (customerOrder.getCode().toString() + " " + customerOrder.getShipping().getShippingStatus()
                    + " " + customerOrder.getCustomer().getFullname() + " " + customerOrder.getCustomer().getCpf());

            if (infoCustomerOrder.toLowerCase().contains(convertString)) {
                customerOrderSearch.add(customerOrder);
            }
        }

        return customerOrderSearch;
    }

    /**
     * Converte uma string para minúsculas e substitui hífens por espaços.
     *
     * @param searchValue Valor de pesquisa a ser convertido.
     * @return String convertida.
     */
    private String convertString(String searchValue){
        return searchValue.toLowerCase().replaceAll("-"," ");
    }
}
