package com.topcare.petshop.service.brand;

import com.topcare.petshop.controller.dto.brand.BrandRequestDTO;
import com.topcare.petshop.controller.dto.brand.BrandResponseDTO;
import com.topcare.petshop.entity.Brand;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface BrandServiceInt {

    List<Brand> findAllBrands();
    List<BrandResponseDTO> findAllBrandsToDTO();

    Brand findBrandByName(String name);
    Brand findBrandById(Long id) throws Exception;

    BrandResponseDTO findBrandToDTO(Long id) throws Exception;

    Brand saveBrand(Brand brand);
    BrandResponseDTO saveBrandFromDTO(BrandRequestDTO brand) throws IOException;
    BrandResponseDTO editBrandFromDTO(Long id, BrandRequestDTO brand) throws Exception;

    void deleteBrand(Long id) throws Exception;
}
