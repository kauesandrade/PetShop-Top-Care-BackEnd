
package com.topcare.petshop.controller.dto.search;
public record SearchRequestDTO(
        String searchValue,
        String sortBy,
        Integer page,
        Integer size
) {
}
