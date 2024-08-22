package com.topcare.petshop.controller;

import com.topcare.petshop.controller.dto.category.cateogoryGroup.CategoryGroupRequestDTO;
import com.topcare.petshop.service.category.categoryGroup.CategoryGroupServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para gerenciamento de grupos de categorias.
 */
@RestController
@RequestMapping("topcare/category")
@AllArgsConstructor
public class CategoryGroupController {

    private final CategoryGroupServiceImpl categoryGroupService;

    /**
     * Cria um novo grupo de categorias.
     *
     * @param categoryGroupDTO Dados do grupo de categorias a ser criado.
     * @return Grupo de categorias criado ou mensagem de erro.
     */
    @PostMapping
    public ResponseEntity createCategoryGroup(@RequestBody CategoryGroupRequestDTO categoryGroupDTO){
        try {
            return new ResponseEntity<>(categoryGroupService.createCategoryGroup(categoryGroupDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    /**
     * Obtém um grupo de categorias pelo ID.
     *
     * @param id ID do grupo de categorias.
     * @return Grupo de categorias correspondente ou mensagem de erro.
     */
    @GetMapping("/{id}")
    public ResponseEntity findCategoryGroupById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(categoryGroupService.getCategoryGroupById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Obtém todos os grupos de categorias.
     *
     * @return Lista de todos os grupos de categorias.
     */
    @GetMapping
    public ResponseEntity findAllCategoryGroup(){
        return new ResponseEntity<>(categoryGroupService.getAllCategoriesGroup(), HttpStatus.OK);
    }

    /**
     * Edita um grupo de categorias existente.
     *
     * @param id ID do grupo de categorias a ser editado.
     * @param categoryGroupDTO Dados atualizados do grupo de categorias.
     * @return Grupo de categorias editado ou mensagem de erro.
     */
    @PutMapping("/{id}")
    public ResponseEntity editCategoryGroup(@PathVariable Long id, @RequestBody CategoryGroupRequestDTO categoryGroupDTO){
        try {
            return new ResponseEntity<>(categoryGroupService.editCategoryGroup(id, categoryGroupDTO) ,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Deleta um grupo de categorias pelo ID.
     *
     * @param id ID do grupo de categorias a ser deletado.
     * @return Status OK ou mensagem de erro.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategoryGroupById(@PathVariable Long id){
        try {
            categoryGroupService.deleteCategoryGroupById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
