package com.topcare.petshop.service.product;

import com.topcare.petshop.repository.ProductImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
/**
 * Implementa os serviços relacionados às imagens de produtos.
 * Fornece métodos para manipulação das imagens de produtos, como exclusão.
 */
@Service
@AllArgsConstructor
public class ProductImageServiceImpl implements ProductImageServiceInt {

    private final ProductImageRepository productImageRepository;

    /**
     * Exclui uma imagem de produto com base no ID fornecido.
     *
     * @param id ID da imagem do produto a ser excluída.
     */
    @Override
    public void deleteById(Long id) {
        productImageRepository.deleteById(id);
    }
}
