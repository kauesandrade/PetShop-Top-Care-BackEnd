package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.image.ImageRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class CustomerImage extends Image {

    public CustomerImage(ImageRequestDTO imageDTO) throws IOException {
        super(imageDTO);
    }

    public CustomerImage(MultipartFile file) throws IOException {
        super(file);
    }

    public static CustomerImage defaultImage() {
        CustomerImage customerImage = new CustomerImage();
        customerImage.setName("default");
        customerImage.setType("image/png");
        customerImage.setSize(187L);
        customerImage.setFile("iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAIAAACQkWg2AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAABQSURBVDhPvY8JCgAgCAT9/6et0MR0g6JjIKpxF4p4k9sFohjQex3kGaSFJAo7wLTV7cuCIdYARvdlPhfCi/MHKscFC/mzJyrJCapGsJ3CXAAnPaN5TXdn6QAAAABJRU5ErkJggg==".getBytes());
        return customerImage;
    }

}
