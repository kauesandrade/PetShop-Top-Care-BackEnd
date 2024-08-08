package com.topcare.petshop.service.productReview;

import com.topcare.petshop.controller.dto.productReview.ProductReviewGetDTO;
import com.topcare.petshop.controller.dto.productReview.ProductReviewPostDTO;
import com.topcare.petshop.repository.ProductReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductReviewServiceImpl implements ProductReviewServiceInt {

    private ProductReviewRepository repository;

    @Override
    public ProductReviewGetDTO getProductReview(Long id) {
        return null;
    }

    @Override
    public ProductReviewPostDTO createProductReview(ProductReviewPostDTO dto) {
        return null;
    }
}
