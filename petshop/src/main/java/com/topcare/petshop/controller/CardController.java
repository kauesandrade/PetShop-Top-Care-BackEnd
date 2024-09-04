package com.topcare.petshop.controller;

import com.topcare.petshop.controller.dto.card.CardRequestDTO;
import com.topcare.petshop.service.card.CardServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para gerenciamento de cartões.
 */
@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/topcare/card")
public class CardController {

    private final CardServiceImpl service;

    /**
     * Obtém um cartão pelo ID.
     *
     * @param id ID do cartão.
     * @return Cartão correspondente ou mensagem de erro.
     */
    @GetMapping("/{id}")
    public ResponseEntity getCard(@PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    service.getCardToDTO(id), HttpStatus.OK
            );
        } catch (Exception e){
            return new ResponseEntity<>(
                    e.getMessage(), HttpStatus.BAD_REQUEST
            );
        }
    }

    /**
     * Obtém todos os cartões.
     *
     * @return Lista de todos os cartões ou mensagem de erro.
     */
    @GetMapping
    public ResponseEntity getAllCards(){
        try {
            return new ResponseEntity<>(
                    service.getAllCards(), HttpStatus.OK
            );
        } catch (Exception e){
            return new ResponseEntity<>(
                    e.getMessage(), HttpStatus.NOT_FOUND
            );
        }
    }

    /**
     * Obtém todos os cartões de um usuário específico.
     *
     * @param userId ID do usuário cujos cartões serão obtidos.
     * @return ResponseEntity contendo a lista de cartões do usuário ou uma mensagem de erro.
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity getCardsByUser(@PathVariable Long userId){
        try {
            return new ResponseEntity<>(
                    service.getCardsOfUserToDTO(userId), HttpStatus.OK
            );
        } catch (Exception e){
            return new ResponseEntity<>(
                    e.getMessage(), HttpStatus.NOT_FOUND
            );
        }
    }

    /**
     * Registra um novo cartão.
     *
     * @param dto Dados do cartão a ser registrado.
     * @return Cartão registrado ou mensagem de erro.
     */
    @PostMapping
    public ResponseEntity registerCard(@RequestBody CardRequestDTO dto){
        try {
            return new ResponseEntity<>(
                    service.registerCard(dto), HttpStatus.OK
            );
        } catch (Exception e){
            return new ResponseEntity(
                    e.getMessage(), HttpStatus.BAD_REQUEST
            );
        }
    }

    /**
     * Edita um cartão existente.
     *
     * @param id ID do cartão a ser editado.
     * @param dto Dados atualizados do cartão.
     * @return Cartão editado ou mensagem de erro.
     */
    @PutMapping("/{id}")
    public ResponseEntity editCard(@PathVariable Long id, @RequestBody CardRequestDTO dto){
        try {
            return new ResponseEntity(
                    service.editCard(id, dto), HttpStatus.OK
            );
        } catch (Exception e){
            return new ResponseEntity(
                    e.getMessage(), HttpStatus.BAD_REQUEST
            );
        }
    }

    /**
     * Deleta um cartão pelo ID.
     *
     * @param id ID do cartão a ser deletado.
     * @return Status OK ou mensagem de erro.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCard(@PathVariable Long id){
        try {
            service.deleteCard(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(
                    e.getMessage(), HttpStatus.BAD_REQUEST
            );
        }
    }
}
