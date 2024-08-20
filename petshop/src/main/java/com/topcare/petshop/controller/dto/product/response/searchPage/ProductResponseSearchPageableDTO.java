package com.topcare.petshop.controller.dto.product.response.searchPage;

import com.topcare.petshop.controller.dto.brand.BrandResponseDTO;
import com.topcare.petshop.controller.dto.category.ProductCategoryResponseDTO;
import com.topcare.petshop.controller.dto.product.response.card.ProductResponseCardDTO;


import java.util.List;

public record ProductResponseSearchPageableDTO(
        ProductResponseCardDTO productCard,
        List<ProductCategoryResponseDTO> categories
) {
}
