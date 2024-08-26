package com.topcare.petshop.controller.dto.product.response.searchPage;

import com.topcare.petshop.controller.dto.brand.BrandResponseDTO;
import com.topcare.petshop.controller.dto.category.ProductCategoryResponseDTO;
import com.topcare.petshop.controller.dto.category.cateogoryGroup.CategoryGroupFiltersResponseDTO;
import com.topcare.petshop.controller.dto.product.response.card.ProductResponseCardDTO;
import com.topcare.petshop.entity.Product;
import org.springframework.data.domain.Pageable;


import java.util.List;

public record ProductResponseSearchPageableDTO(
        List<ProductResponseCardDTO> productCard,
        List<CategoryGroupFiltersResponseDTO> categories
) {

}
