package com.topcare.petshop.service.productReview;

import com.topcare.petshop.controller.dto.productReview.ProductReviewGetDTO;
import com.topcare.petshop.controller.dto.productReview.ProductReviewPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface ProductReviewServiceInt {

    ProductReviewGetDTO getProductReview(Long id);
    ProductReviewPostDTO createProductReview(ProductReviewPostDTO dto);

}
