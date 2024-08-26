package com.topcare.petshop.controller;

import com.topcare.petshop.controller.dto.search.SearchRequestDTO;
import com.topcare.petshop.service.product.ProductServiceImpl;
import com.topcare.petshop.service.service.ServiceServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para busca de produtos e serviços.
 */
@RestController
@RequestMapping("topcare/search")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class SearchController {

    private final ProductServiceImpl productService;
    private final ServiceServiceImpl serviceService;

    /**
     * Pesquisa produtos com base em critérios especificados.
     *
     * @param searchValue Valor de pesquisa.
     * @param sortBy Critério de ordenação.
     * @param page Número da página de resultados.
     * @param size Tamanho da página de resultados.
     * @param productCategories Lista de IDs de categorias de produtos.
     * @return Lista de produtos que atendem aos critérios de pesquisa.
     * @throws Exception Se ocorrer um erro durante a pesquisa.
     */
    @PutMapping("/product")
    public ResponseEntity searchProduct(@RequestParam(required = false) String searchValue,
                                        @RequestParam(required = false) String sortBy,
                                        @RequestParam(defaultValue = "0") Integer page,
                                        @RequestParam(defaultValue = "10") Integer size,
                                        @RequestBody(required = false) List<Long> productCategories) throws Exception {
        SearchRequestDTO searchDTO = new SearchRequestDTO(searchValue, sortBy, page, size);
        return new ResponseEntity<>(productService.searchProduct(searchDTO, productCategories), HttpStatus.OK);
    }

    /**
     * Pesquisa serviços com base em critérios especificados.
     *
     * @param searchValue Valor de pesquisa.
     * @param sortBy Critério de ordenação.
     * @param page Número da página de resultados.
     * @param size Tamanho da página de resultados.
     * @return Lista de serviços que atendem aos critérios de pesquisa.
     */
    @GetMapping("/service")
    public ResponseEntity searchService(@RequestParam(required = false) String searchValue,
                                        @RequestParam(required = false) String sortBy,
                                        @RequestParam(defaultValue = "0") Integer page,
                                        @RequestParam(defaultValue = "10") Integer size) {
        SearchRequestDTO searchDTO = new SearchRequestDTO(searchValue, sortBy, page, size);
        return new ResponseEntity<>(serviceService.searchService(searchDTO), HttpStatus.OK);
    }
}
