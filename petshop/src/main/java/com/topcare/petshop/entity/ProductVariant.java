package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.product.request.ProductVariantRequestPostDTO;
import com.topcare.petshop.controller.dto.product.request.ProductVariantRequestPutDTO;
import com.topcare.petshop.controller.dto.product.response.page.ProductVariantResponsePageDTO;
import com.topcare.petshop.controller.dto.product.response.page.ProductVariantResponsePageEditDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
/**
 * Representa uma variante de um produto, que pode ter diferentes características e preços.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Código único da variante.
     */
    @Column(nullable = false)
    private Long variantCode;

    /**
     * Título da variante.
     */
    @Column(nullable = false)
    private String variantTitle;

    /**
     * Imagens associadas à variante do produto.
     */
    @OneToMany
    @JoinColumn(name = "product_variant_id", nullable = false)
    private List<ProductImage> images;

    /**
     * Preço da variante.
     */
    @Column(nullable = false)
    private Double price;

    /**
     * Desconto aplicado à variante.
     */
    @Column(nullable = false)
    private Double discount;

    /**
     * Quantidade em estoque da variante.
     */
    @Column(nullable = false)
    private Integer stock;

    /**
     * Indica se a variante está disponível para venda.
     */
    @Column(nullable = false)
    private Boolean available;

    /**
     * Constrói uma ProductVariant a partir de um DTO de variante de produto.
     *
     * @param productVariant DTO de variante do produto.
     */
    public ProductVariant(ProductVariantRequestPostDTO productVariant) {
        setVariantCode(productVariant.variantCode());
        setVariantTitle(productVariant.variantTitle());
        setPrice(productVariant.price());
        setDiscount(productVariant.discount());
        setStock(productVariant.stock());
        setImages(new ArrayList<>());

        /** Define a disponibilidade com base no estoque.*/
        setAvailable(productVariant.stock() > 0);
    }

    public ProductVariant(ProductVariantRequestPutDTO productVariant){
        setId(productVariant.variantId());
        setVariantCode(productVariant.variantCode());
        setVariantTitle(productVariant.variantTitle());
        setPrice(productVariant.price());
        setDiscount(productVariant.discount());
        setStock(productVariant.stock());
        setAvailable(productVariant.stock() > 0);
        setImages(new ArrayList<>());
    }

    /**
     * Converte a variante do produto para um DTO de página.
     *
     * @return DTO da variante de produto.
     */
    public ProductVariantResponsePageDTO toDTO() {

        /** Verifica se o estoque está disponível.*/
        Boolean isStockAvailable = stock > 0;

        /** Calcula o preço com desconto.*/
        Double discountPrice = price - (price * (discount / 100));

        return new ProductVariantResponsePageDTO(
                getVariantTitle(),
                getVariantCode(),
                getPrice(),
                discountPrice,
                2, /** Pode ser um valor fixo ou calculado de outra forma.*/
                isStockAvailable,
                getImages()
        );
    }

    public ProductVariantResponsePageEditDTO toEditDTO() {

        return new ProductVariantResponsePageEditDTO(
                getId(),
                getVariantTitle(),
                getVariantCode(),
                getPrice(),
                getDiscount(),
                getStock(),
                getImages()
        );
    }
}
