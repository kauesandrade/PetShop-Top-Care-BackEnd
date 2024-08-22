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

import java.io.IOException;
/**
 * Representa uma imagem de um pet.
 * Herda de {@link Image}.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class PetImage extends Image {

    /**
     * Constrói uma PetImage a partir de um DTO de imagem.
     *
     * @param imageDTO DTO de imagem.
     * @throws IOException Se ocorrer um erro ao processar o arquivo da imagem.
     */
    public PetImage(ImageRequestDTO imageDTO) throws IOException {
        super(imageDTO);
    }
}

