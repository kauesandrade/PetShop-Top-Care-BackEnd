package com.topcare.petshop.service.brand;

import com.topcare.petshop.entity.Brand;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface BrandServiceInt {

    Brand findBrandByName(String name);
}
