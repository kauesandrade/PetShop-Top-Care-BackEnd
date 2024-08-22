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

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class PetImage extends Image {
    public PetImage(ImageRequestDTO imageDTO) throws IOException {
        super(imageDTO);
    }
}
