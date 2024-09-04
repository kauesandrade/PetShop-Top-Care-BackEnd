package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
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
     * Cria uma imagem de perfil padrão.
     *
     * @return Imagem de perfil padrão.
     */
    public static CustomerImage defaultImage() {
        CustomerImage customerImage = new CustomerImage();
        customerImage.setName("default");
        customerImage.setType("image/png");
        customerImage.setSize(187L);
        customerImage.setFile("iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAIAAACQkWg2AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAABQSURBVDhPvY8JCgAgCAT9/6et0MR0g6JjIKpxF4p4k9sFohjQex3kGaSFJAo7wLTV7cuCIdYARvdlPhfCi/MHKscFC/mzJyrJCapGsJ3CXAAnPaN5TXdn6QAAAABJRU5ErkJggg==".getBytes());
        return customerImage;
    }

}
