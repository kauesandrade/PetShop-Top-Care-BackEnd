package com.topcare.petshop.controller.dto;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public record SearchResquestDTO(
        String search,
        String sortBy,
        Integer page,
        Integer size,
        List<Long> productCategoryList
) {
}
