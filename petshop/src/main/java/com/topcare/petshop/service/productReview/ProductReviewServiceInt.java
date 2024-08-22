package com.topcare.petshop.service.productReview;

import com.topcare.petshop.controller.dto.productReview.ProductReviewGetDTO;
import com.topcare.petshop.controller.dto.productReview.ProductReviewPostDTO;
import com.topcare.petshop.entity.ProductReview;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductReviewServiceInt {

    ProductReviewPostDTO createProductReview(ProductReviewPostDTO dto);
    void deleteProductReview(Long id);

}
