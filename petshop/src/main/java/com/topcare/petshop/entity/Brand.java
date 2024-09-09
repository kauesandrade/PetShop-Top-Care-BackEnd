package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.brand.BrandRequestDTO;
import com.topcare.petshop.controller.dto.brand.BrandResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;

/**
 * Entidade para marcas de produtos.
 * Contém informações sobre uma marca e sua imagem associada.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(nullable = false)
    private BrandImage image;

    /**
     * Construtor que inicializa a entidade com base em um DTO de solicitação de marca.
     *
     * @param brand DTO com os dados da marca.
     * @throws IOException Se ocorrer um erro ao processar a imagem.
     */
    public Brand(BrandRequestDTO brand) throws IOException {
        this.name = brand.name();
        this.image = new BrandImage(brand.image());
    }

    /**
     * Atualiza os dados da marca com base em um DTO de solicitação de marca.
     *
     * @param brand DTO com os dados atualizados da marca.
     * @throws IOException Se ocorrer um erro ao processar a imagem.
     */
    public void edit(BrandRequestDTO brand) throws IOException {
        this.name = brand.name();
        this.image.editFromFile(brand.image());
    }

    /**
     * Converte a entidade para um DTO (Data Transfer Object).
     *
     * @return DTO com os dados da marca.
     */
    public BrandResponseDTO toDTO() {
        return new BrandResponseDTO(
                getId(),
                getName(),
                getImage().toDTO()
        );
    }
}
