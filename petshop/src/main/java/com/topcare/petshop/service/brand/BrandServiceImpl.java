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
/**
 * Implementa os serviços relacionados à entidade {@link Brand}.
 * Fornece métodos para manipulação de marcas, incluindo criação, leitura, atualização e exclusão.
 */
@Service
@AllArgsConstructor
public class BrandServiceImpl implements BrandServiceInt {

    private final BrandRepository repository;

    /**
     * Retorna uma lista de todas as marcas.
     *
     * @return Lista de marcas.
     */
    @Override
    public List<Brand> findAllBrands() {
        return repository.findAll();
    }

    /**
     * Retorna uma lista de todas as marcas convertidas para DTOs.
     *
     * @return Lista de DTOs de marcas.
     */
    @Override
    public List<BrandResponseDTO> findAllBrandsToDTO() {
        return findAllBrands().stream().map(Brand::toDTO).toList();
    }

    /**
     * Encontra uma marca pelo nome.
     *
     * @param name Nome da marca.
     * @return Marca encontrada, ou uma nova instância vazia se não encontrada.
     */
    @Override
    public Brand findBrandByName(String name) {
        return repository.findBrandByName(name).orElse(new Brand());
    }

    /**
     * Encontra uma marca pelo ID.
     *
     * @param id ID da marca.
     * @return Marca encontrada.
     * @throws Exception Se a marca não for encontrada.
     */
    @Override
    public Brand findBrandById(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Marca não encontrada"));
    }

    /**
     * Retorna um DTO da marca com o ID fornecido.
     *
     * @param id ID da marca.
     * @return DTO da marca.
     * @throws Exception Se a marca não for encontrada.
     */
    @Override
    public BrandResponseDTO findBrandToDTO(Long id) throws Exception {
        return findBrandById(id).toDTO();
    }

    /**
     * Salva uma nova marca.
     *
     * @param brand Marca a ser salva.
     * @return Marca salva.
     */
    @Override
    public Brand saveBrand(Brand brand) {
        return repository.save(brand);
    }

    /**
     * Salva uma nova marca a partir de um DTO e retorna o DTO da marca salva.
     *
     * @param brand DTO da marca.
     * @return DTO da marca salva.
     * @throws IOException Se ocorrer um erro ao processar o DTO.
     */
    @Override
    public BrandResponseDTO saveBrandFromDTO(BrandRequestDTO brand) throws IOException {
        Brand brandEntity = new Brand(brand);
        return saveBrand(brandEntity).toDTO();
    }

    /**
     * Edita uma marca existente com base no ID e no DTO fornecidos.
     *
     * @param id ID da marca a ser editada.
     * @param brand DTO com as novas informações.
     * @return DTO da marca editada.
     * @throws Exception Se a marca não for encontrada.
     */
    @Override
    public BrandResponseDTO editBrandFromDTO(Long id, BrandRequestDTO brand) throws Exception {
        Brand brandEntity = findBrandById(id);
        brandEntity.edit(brand);
        return saveBrand(brandEntity).toDTO();
    }

    /**
     * Exclui uma marca pelo ID.
     *
     * @param id ID da marca a ser excluída.
     * @throws Exception Se a marca não for encontrada.
     */
    @Override
    public void deleteBrand(Long id) throws Exception {
        findBrandById(id);
        repository.deleteById(id);
    }
}
