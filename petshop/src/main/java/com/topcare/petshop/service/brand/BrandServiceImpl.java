package com.topcare.petshop.service.brand;

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
        Brand brand = repository.findBrandbyName(name).get();
        return brand;
    }
}
