package com.topcare.petshop.controller;

import com.topcare.petshop.controller.dto.brand.BrandRequestDTO;
import com.topcare.petshop.service.brand.BrandServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para gerenciamento de marcas.
 */
@RestController
@RequestMapping("topcare/brand")
@AllArgsConstructor
@CrossOrigin("*")
public class BrandController {

    private final BrandServiceImpl service;

    /**
     * Obtém todas as marcas.
     *
     * @return Lista de todas as marcas com status OK.
     */
    @GetMapping
    public ResponseEntity getAllBrands() {
        return new ResponseEntity(service.findAllBrandsToDTO(), HttpStatus.OK);
    }

    /**
     * Obtém uma marca pelo ID.
     *
     * @param id ID da marca.
     * @return Marca correspondente ou mensagem de erro se não encontrada.
     */
    @GetMapping("/{id}")
    public ResponseEntity getBrand(@PathVariable Long id) {
        try {
            return new ResponseEntity(service.findBrandToDTO(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Cria uma nova marca.
     *
     * @param brand Dados da marca para criação.
     * @return Marca criada ou mensagem de erro.
     */
    @PostMapping
    public ResponseEntity createBrand(@ModelAttribute BrandRequestDTO brand) {
        try {
            return new ResponseEntity(service.saveBrandFromDTO(brand), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Edita uma marca existente.
     *
     * @param id ID da marca a ser editada.
     * @param brand Dados da marca atualizados.
     * @return Marca editada ou mensagem de erro.
     */
    @PutMapping("/{id}")
    public ResponseEntity editBrand(@PathVariable Long id, @ModelAttribute BrandRequestDTO brand) {
        try {
            return new ResponseEntity(service.editBrandFromDTO(id, brand), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Deleta uma marca pelo ID.
     *
     * @param id ID da marca a ser deletada.
     * @return Status OK ou mensagem de erro.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteBrand(@PathVariable Long id) {
        try {
            service.deleteBrand(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
