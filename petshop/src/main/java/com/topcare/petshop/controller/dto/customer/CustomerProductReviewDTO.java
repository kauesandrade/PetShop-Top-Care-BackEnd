package com.topcare.petshop.controller.dto.customer;

import com.topcare.petshop.entity.CustomerImage;

public record CustomerProductReviewDTO(

        byte[] profileImage,
        String fullname

) {
}
