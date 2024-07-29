package com.topcare.petshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceVariant extends Service {

    @Column(nullable = false, unique = true)
    private Long variantCode;

    @Column(nullable = false, length = 60)
    private String variantTitle;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private LocalTime estimatedTime;

}
