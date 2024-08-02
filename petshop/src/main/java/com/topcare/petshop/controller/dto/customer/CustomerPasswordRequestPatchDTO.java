package com.topcare.petshop.controller.dto.customer;

import com.topcare.petshop.controller.dto.address.CustomerAddressRequestPostDTO;

public record CustomerPasswordRequestPatchDTO(String oldPassword, String newPassword) {
}
