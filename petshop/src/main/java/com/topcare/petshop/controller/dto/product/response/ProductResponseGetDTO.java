package com.topcare.petshop.controller.dto.product.response;

import java.util.List;

public record ProductResponseGetDTO(
        ProductResponseDTO productDTO,
        List<ProductVariantResponseDTO> productVariantsDTO
) { }
