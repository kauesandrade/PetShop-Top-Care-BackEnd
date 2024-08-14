package com.topcare.petshop.service.productReview;

import com.topcare.petshop.controller.dto.productReview.ProductReviewGetDTO;
import com.topcare.petshop.controller.dto.productReview.ProductReviewPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductReviewServiceInt {

    List<ProductReviewGetDTO> getProductReview(Long id);
    ProductReviewPostDTO createProductReview(ProductReviewPostDTO dto);

}
