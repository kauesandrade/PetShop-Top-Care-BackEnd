package com.topcare.petshop.service.brand;

import com.topcare.petshop.controller.dto.brand.BrandRequestDTO;
import com.topcare.petshop.controller.dto.brand.BrandResponseDTO;
import com.topcare.petshop.entity.Brand;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
/**
 * Interface para os serviços relacionados à entidade {@link Brand}.
 * Define os métodos para manipulação de marcas, incluindo criação, leitura, atualização e exclusão.
 */
@Service
public interface BrandServiceInt {

    /**
     * Retorna uma lista de todas as marcas.
     *
     * @return Lista de marcas.
     */
    List<Brand> findAllBrands();

    /**
     * Retorna uma lista de todas as marcas convertidas para DTOs.
     *
     * @return Lista de DTOs de marcas.
     */
    List<BrandResponseDTO> findAllBrandsToDTO();

    /**
     * Encontra uma marca pelo nome.
     *
     * @param name Nome da marca.
     * @return Marca encontrada.
     */
    Brand findBrandByName(String name);

    /**
     * Encontra uma marca pelo ID.
     *
     * @param id ID da marca.
     * @return Marca encontrada.
     * @throws Exception Se a marca não for encontrada.
     */
    Brand findBrandById(Long id) throws Exception;

    /**
     * Retorna um DTO da marca com o ID fornecido.
     *
     * @param id ID da marca.
     * @return DTO da marca.
     * @throws Exception Se a marca não for encontrada.
     */
    BrandResponseDTO findBrandToDTO(Long id) throws Exception;

    /**
     * Salva uma nova marca.
     *
     * @param brand Marca a ser salva.
     * @return Marca salva.
     */
    Brand saveBrand(Brand brand);

    /**
     * Salva uma nova marca a partir de um DTO e retorna o DTO da marca salva.
     *
     * @param brand DTO da marca.
     * @return DTO da marca salva.
     * @throws IOException Se ocorrer um erro ao processar o DTO.
     */
    BrandResponseDTO saveBrandFromDTO(BrandRequestDTO brand) throws IOException;

    /**
     * Edita uma marca existente com base no ID e no DTO fornecidos.
     *
     * @param id ID da marca a ser editada.
     * @param brand DTO com as novas informações.
     * @return DTO da marca editada.
     * @throws Exception Se a marca não for encontrada.
     */
    BrandResponseDTO editBrandFromDTO(Long id, BrandRequestDTO brand) throws Exception;

    /**
     * Exclui uma marca pelo ID.
     *
     * @param id ID da marca a ser excluída.
     * @throws Exception Se a marca não for encontrada.
     */
    void deleteBrand(Long id) throws Exception;
}
