package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import com.topcare.petshop.controller.dto.image.ImageResponseDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Base64;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Image {

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

    public Image(MultipartFile file) throws IOException {
        this.name = file.getName();
        this.type = file.getContentType();
        this.size = file.getSize();
        this.file = file.getBytes();
    }

    public ImageResponseDTO toDTO() {
        String url = "data:" + this.type + ";base64," + Base64.getEncoder().encodeToString(this.file);
        return new ImageResponseDTO(this.name, this.type, this.size, url);
    }

    public void edit(ImageRequestDTO imageDTO) throws IOException {
        this.name = imageDTO.file().getName();
        this.type = imageDTO.file().getContentType();
        this.size = imageDTO.file().getSize();
        this.file = imageDTO.file().getBytes();
    }

}
