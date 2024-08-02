package com.topcare.petshop.controller;

import com.topcare.petshop.controller.dto.card.CardRequestDTO;
import com.topcare.petshop.service.card.CardServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/topcare/card")
public class CardController {

    private CardServiceImpl service;

    @GetMapping("/{id}")
    public ResponseEntity getCard(@PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    service.getCard(id), HttpStatus.OK
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
}
