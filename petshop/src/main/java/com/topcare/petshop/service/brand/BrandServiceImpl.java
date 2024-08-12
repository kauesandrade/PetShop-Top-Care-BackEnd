package com.topcare.petshop.service.brand;

import com.topcare.petshop.controller.dto.brand.BrandResponseDTO;
import com.topcare.petshop.entity.Brand;
import com.topcare.petshop.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandServiceImpl implements BrandServiceInt{

    private final BrandRepository repository;

    @Override
    public Brand findBrandByName(String name) {
        Brand brand = new Brand();
        if(repository.findBrandByName(name).isPresent()){
            brand = repository.findBrandByName(name).get();
        }
        return brand;
    }

    @Override
    public Brand findBrandById(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Marca não encontrada"));
    }

    @Override
    public BrandResponseDTO findBrandToDTO(Long id) throws Exception {
        return findBrandById(id).toDTO();
    }


}
