package com.topcare.petshop.service.product;

import com.topcare.petshop.repository.ProductImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductImageServiceImpl implements ProductImageServiceInt{

    private ProductImageRepository productImageRepository;

    @Override
    public void deleteById(Long id) {
        productImageRepository.deleteById(id);
    }
}
