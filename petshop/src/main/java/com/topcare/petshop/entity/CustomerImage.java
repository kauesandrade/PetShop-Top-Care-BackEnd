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
 * Representa a imagem de perfil de um cliente.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class CustomerImage extends Image {

    /**
     * Constrói uma CustomerImage a partir de um DTO de imagem.
     *
     * @param imageDTO DTO de imagem.
     * @throws IOException Se ocorrer um erro ao processar o arquivo da imagem.
     */
    public CustomerImage(ImageRequestDTO imageDTO) throws IOException {
        super(imageDTO);
    }

    /**
     * Constrói uma CustomerImage a partir de um arquivo Multipart.
     *
     * @param file Arquivo Multipart representando a imagem.
     * @throws IOException Se ocorrer um erro ao processar o arquivo da imagem.
     */
    public CustomerImage(MultipartFile file) throws IOException {
        super(file);
    }

    /**
     * Constrói uma CustomerImage a partir de um array de bytes.
     *
     * @param bytes Array de bytes representando a imagem.
     */
    public CustomerImage(byte[] bytes) {
        super(bytes);
    }
}
