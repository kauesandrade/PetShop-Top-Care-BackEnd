package com.topcare.petshop.service.filter;

import com.topcare.petshop.entity.Product;
import com.topcare.petshop.entity.ProductCategory;
import com.topcare.petshop.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
/**
 * Implementa os serviços relacionados ao filtro de produtos.
 * Fornece métodos para filtrar produtos com base nas categorias fornecidas.
 */
@Service
@AllArgsConstructor
public class FilterServiceImpl implements FilterServiceInt {

    private final ProductRepository productRepository;

    /**
     * Filtra produtos com base em uma lista de IDs de categorias.
     * Se a lista de categorias estiver vazia, retorna todos os produtos.
     *
     * @param productCategoryList Lista de IDs de categorias.
     * @return Lista de produtos filtrados.
     */
    @Override
    public List<Product> filterProducts(List<Long> productCategoryList) {
        if (productCategoryList.isEmpty()) {
            return productRepository.findAll().stream().toList();
        }
        return findAllByCategoryIds(productCategoryList);
    }

    /**
     * Retorna uma lista de produtos com base em IDs de categorias fornecidos.
     *
     * @param productCategoryList Lista de IDs de categorias.
     * @return Lista de produtos filtrados.
     */
    private List<Product> findAllByCategoryIds(List<Long> productCategoryList) {
        HashMap<Long, Product> productList = new HashMap<>();
        System.out.println(productCategoryList);
        for (Long idProduct : productRepository.findAllByCategoryIds(productCategoryList, productCategoryList.size())) {
            productList.put(idProduct, productRepository.findById(idProduct).get());
        }
        return productList.values().stream().toList();
    }
}
