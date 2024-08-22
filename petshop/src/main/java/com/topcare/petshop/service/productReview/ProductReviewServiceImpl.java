package com.topcare.petshop.service.productReview;

import com.topcare.petshop.controller.dto.productReview.ProductReviewGetDTO;
import com.topcare.petshop.controller.dto.productReview.ProductReviewPostDTO;
import com.topcare.petshop.entity.ProductReview;
import com.topcare.petshop.repository.ProductReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductReviewServiceImpl implements ProductReviewServiceInt {

    private ProductReviewRepository repository;

    @Override
    public ProductReviewPostDTO createProductReview(ProductReviewPostDTO dto) {
        ProductReview productReview = ProductReview.builder()
                .customer(dto.customerId())
                .review(dto.review())
                .rating(dto.rating()).build();

        repository.save(productReview);

        return dto;
    }

    @Override
    public void deleteProductReview(Long id) {
        repository.deleteById(id);
    }
}
