package com.topcare.petshop.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topcare/search")
@AllArgsConstructor
public class SearchController {

    @GetMapping("/product")
}
