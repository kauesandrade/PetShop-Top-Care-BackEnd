package com.topcare.petshop.service.brand;

import com.topcare.petshop.controller.dto.brand.BrandResponseDTO;
import com.topcare.petshop.entity.Brand;
import org.springframework.stereotype.Service;

@Service
public interface BrandServiceInt {

    Brand findBrandByName(String name);

    Brand findBrandById(Long id) throws Exception;
    BrandResponseDTO findBrandToDTO(Long id) throws Exception;
}
