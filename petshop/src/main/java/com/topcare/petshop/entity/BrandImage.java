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

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class BrandImage extends Image {
    public BrandImage(ImageRequestDTO imageDTO) throws IOException {
        super(imageDTO);
    }

    public BrandImage(MultipartFile file) throws IOException {
        super(file);
    }
}
