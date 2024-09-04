package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Entidade para imagens de marcas.
 * Extende a entidade Image e adiciona funcionalidades específicas.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class BrandImage extends Image {

    /**
     * Construtor que inicializa a entidade com base em um DTO de imagem.
     *
     * @param imageDTO DTO com os dados da imagem.
     * @throws IOException Se ocorrer um erro ao processar a imagem.
     */
    public BrandImage(ImageRequestDTO imageDTO) throws IOException {
        super(imageDTO);
    }

    /**
     * Construtor que inicializa a entidade com base em um arquivo MultipartFile.
     *
     * @param file Arquivo de imagem.
     * @throws IOException Se ocorrer um erro ao processar o arquivo.
     */
    public BrandImage(MultipartFile file) throws IOException {
        super(file);
    }
}
