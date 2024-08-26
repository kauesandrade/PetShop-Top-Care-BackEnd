package com.topcare.petshop.controller.dto.product.request;

import com.topcare.petshop.controller.dto.product.response.page.ProductSpecificationResponsePageDTO;
import com.topcare.petshop.entity.Brand;
import com.topcare.petshop.entity.ProductCategory;

import java.util.List;

public record ProductRequestPostDTO(

        String title,
        Long code,
        String description,
        String shortDescription,
        Brand brand,
        List<ProductCategory> categories,
        List<ProductSpecificationResponsePageDTO> specifications,
        List<ProductVariantRequestPostDTO> variants

) {
}
