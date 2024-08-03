package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import com.topcare.petshop.controller.dto.image.ImageResponseDTO;
import jakarta.persistence.*;
import lombok.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    private Long size;

    @Lob
    @Column(columnDefinition = "BLOB", nullable = false)
    @NonNull
    private byte[] file;

    public Image(ImageRequestDTO imageDTO) throws IOException {
        this.name = imageDTO.file().getName();
        this.type = imageDTO.file().getContentType();
        this.size = imageDTO.file().getSize();
        this.file = imageDTO.file().getBytes();
    }

    public ImageResponseDTO toDTO() throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(this.file);

        BufferedImage newImage = ImageIO.read(inputStream);
        File image = new File(this.name + this.type);
        ImageIO.write(newImage, this.type, image);

        return new ImageResponseDTO(this.name, this.type, this.size, image.toURI().toURL().toString());
    }

    public void edit(ImageRequestDTO imageDTO) throws IOException {
        this.name = imageDTO.file().getName();
        this.type = imageDTO.file().getContentType();
        this.size = imageDTO.file().getSize();
        this.file = imageDTO.file().getBytes();
    }

}
