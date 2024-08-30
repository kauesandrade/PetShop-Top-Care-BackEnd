package com.topcare.petshop.configuration;

import com.topcare.petshop.entity.CustomerImage;
import com.topcare.petshop.entity.Image;
import com.topcare.petshop.repository.ImageRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class ImageInsert {

    private final ImageRepository imageRepository;

    @PostConstruct
    public void insertImages() {
//        List<Image> images = new ArrayList<>();
//        for (int i = 0; i < 30; i++) {
//            Image image = new CustomerImage();
//            image.setName("oi.png");
//            image.setFile("iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAIAAACQkWg2AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAABQSURBVDhPvY8JCgAgCAT9/6et0MR0g6JjIKpxF4p4k9sFohjQex3kGaSFJAo7wLTV7cuCIdYARvdlPhfCi/MHKscFC/mzJyrJCapGsJ3CXAAnPaN5TXdn6QAAAABJRU5ErkJggg==".getBytes());
//            image.setType("image/png");
//            image.setSize(187L);
//            images.add(image);
//        }
//        imageRepository.saveAll(images);
    }

}
