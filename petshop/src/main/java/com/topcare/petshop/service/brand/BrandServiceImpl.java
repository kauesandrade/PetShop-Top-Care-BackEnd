package com.topcare.petshop.service.brand;

import com.topcare.petshop.controller.dto.brand.BrandRequestDTO;
import com.topcare.petshop.controller.dto.brand.BrandResponseDTO;
import com.topcare.petshop.entity.Brand;
import com.topcare.petshop.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandServiceImpl implements BrandServiceInt{

    private final BrandRepository repository;

    @Override
    public List<Brand> findAllBrands() {
        return repository.findAll();
    }

    @Override
    public List<BrandResponseDTO> findAllBrandsToDTO() {
        return findAllBrands().stream().map(Brand::toDTO).toList();
    }

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

    @Override
    public Brand saveBrand(Brand brand) {
        return repository.save(brand);
    }

    @Override
    public BrandResponseDTO saveBrandFromDTO(BrandRequestDTO brand) throws IOException {
        Brand brandEntity = new Brand(brand);
        return saveBrand(brandEntity).toDTO();
    }

    @Override
    public BrandResponseDTO editBrandFromDTO(Long id, BrandRequestDTO brand) throws Exception {
        Brand brandEntity = findBrandById(id);
        brandEntity.edit(brand);
        return saveBrand(brandEntity).toDTO();
    }

    @Override
    public void deleteBrand(Long id) throws Exception {
        findBrandById(id);
        repository.deleteById(id);
    }

}
