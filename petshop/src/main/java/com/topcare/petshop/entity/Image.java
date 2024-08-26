package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import com.topcare.petshop.controller.dto.image.ImageResponseDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
        this.name = imageDTO.file().getOriginalFilename();
        this.type = imageDTO.file().getContentType();
        this.size = imageDTO.file().getSize();
        this.file = imageDTO.file().getBytes();
    }

    public Image(MultipartFile file) throws IOException {
        this.name = file.getOriginalFilename();
        this.type = file.getContentType();
        this.size = file.getSize();
        this.file = file.getBytes();
    }

    public ImageResponseDTO toDTO() {
        String url = "data:" + this.type + ";base64," + Base64.getEncoder().encodeToString(this.file);
        return new ImageResponseDTO(this.name, this.type, this.size, url);
    }

    public void editFromFile(MultipartFile file) throws IOException {
        this.name = file.getOriginalFilename();
        this.type = file.getContentType();
        this.size = file.getSize();
        this.file = file.getBytes();
    }

    public void editFromDTO(ImageRequestDTO imageDTO) throws IOException {
        editFromFile(imageDTO.file());
    }

}
