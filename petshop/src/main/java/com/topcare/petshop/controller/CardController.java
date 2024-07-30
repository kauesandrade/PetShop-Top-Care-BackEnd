package com.topcare.petshop.controller;

import com.topcare.petshop.controller.dto.card.CardRequestGetPostDTO;
import com.topcare.petshop.service.Card.CardServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/topcare/card")
public class CardController {

    private CardServiceImpl service;

    @GetMapping("/{id}")
    public ResponseEntity<CardRequestGetPostDTO> getCard(@PathVariable Long id){
        return new ResponseEntity<>(
                service.getCard(id), HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<CardRequestGetPostDTO> registerCard(@RequestBody CardRequestGetPostDTO dto){
        return new ResponseEntity<>(
                service.registerCard(dto), HttpStatus.OK
        );
    }
}
