package com.topcare.petshop.controller.dto.search;

import java.util.List;

public record SearchResquestDTO(
        String search,
        String sortBy,
        Integer page,
        Integer size,
        List<Long> productCategoryList
) {
}
