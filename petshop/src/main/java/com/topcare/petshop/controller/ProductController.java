package com.topcare.petshop.controller;

import com.topcare.petshop.controller.dto.product.request.ProductRequestPostDTO;
import com.topcare.petshop.controller.dto.product.response.page.ProductResponsePageDTO;
import com.topcare.petshop.service.product.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gerenciamento de produtos.
 */
@RestController
@RequestMapping("topcare/product")
@CrossOrigin("*")
@AllArgsConstructor
public class ProductController {

    private final ProductServiceImpl productService;

    /**
     * Obtém um produto pelo código.
     *
     * @param code Código do produto.
     * @return Produto correspondente ou mensagem de erro se não encontrado.
     */
    @GetMapping("/{code}")
    public ResponseEntity getProductByCode(@PathVariable Long code) {
        try {
            return new ResponseEntity<>(productService.getProductByCode(code), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Obtém produtos similares ao produto especificado pelo código.
     *
     * @param code Código do produto.
     * @return Lista de produtos similares ou mensagem de erro se não encontrados.
     */
    @GetMapping("/similar/{code}")
    public ResponseEntity getSimilarProductsByCode(@PathVariable Long code) {
        try {
            return new ResponseEntity<>(productService.getSimilarProductsByCode(code), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Obtém produtos filtrados por categorias.
     *
     * @param categories Lista de IDs de categorias.
     * @return Lista de produtos nas categorias especificadas ou mensagem de erro se não encontrados.
     */
    @PutMapping("/categories")
    public ResponseEntity getProductsByCategories(@RequestBody List<Long> categories) {
        try {
            return new ResponseEntity<>(productService.getProductsByCategories(categories), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Cria um novo produto.
     *
     * @param productDTO Dados do produto a ser criado.
     * @return Produto criado ou mensagem de erro.
     * @throws Exception Se ocorrer um erro durante a criação.
     */
    @PostMapping
    public ResponseEntity createProduct(@RequestBody ProductRequestPostDTO productDTO) throws Exception {
        try {
            return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Edita um produto existente.
     *
     * @param code Código do produto a ser editado.
     * @param productDTO Dados atualizados do produto.
     * @return Produto editado ou mensagem de erro.
     */
    @PutMapping("/{code}")
    public ResponseEntity<ProductResponsePageDTO> editProduct(@PathVariable Long code, @RequestBody ProductRequestPostDTO productDTO) {
        return new ResponseEntity<>(productService.editProduct(productDTO, code), HttpStatus.OK);
    }

    /**
     * Deleta um produto pelo código.
     *
     * @param code Código do produto a ser deletado.
     * @return Status OK ou mensagem de erro.
     */
    @DeleteMapping("/{code}")
    public ResponseEntity deleteProduct(@PathVariable Long code) {
        try {
            productService.deleteProductByCode(code);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
