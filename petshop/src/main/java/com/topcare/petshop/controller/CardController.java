package com.topcare.petshop.controller;

import com.topcare.petshop.controller.dto.card.CardRequestDTO;
import com.topcare.petshop.service.card.CardServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/topcare/card")
public class CardController {

    private CardServiceImpl service;

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
