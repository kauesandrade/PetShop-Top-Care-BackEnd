package com.topcare.petshop.service.product;

import org.springframework.stereotype.Service;
/**
 * Interface para os serviços relacionados às imagens de produtos.
 * Define métodos para manipulação das imagens de produtos, como exclusão.
 */
@Service
public interface ProductImageServiceInt {

    /**
     * Exclui uma imagem de produto com base no ID fornecido.
     *
     * @param id ID da imagem do produto a ser excluída.
     */
    void deleteById(Long id);
}
