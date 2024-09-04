package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.IOException;

/**
 * A classe ServiceImage representa uma imagem associada a um serviço.
 * Herda da classe Image e é inicializada a partir de um DTO de solicitação de imagem.
 *
 * Anotações:
 * - @Entity: Define que a classe será mapeada para uma tabela no banco de dados.
 * - @Data: Gera automaticamente getters, setters, equals, hashCode e toString.
 * - @NoArgsConstructor: Gera um construtor sem argumentos.
 * - @EqualsAndHashCode(callSuper = true): Inclui os campos da superclasse no equals e hashCode.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class ServiceImage extends Image {

    public ServiceImage(ImageRequestDTO imageDTO) throws IOException {
        super(imageDTO);
    }

}
