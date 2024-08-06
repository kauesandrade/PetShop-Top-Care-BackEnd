package com.topcare.petshop.entity;

import com.topcare.petshop.controller.dto.product.request.ProductRequestPostDTO;
import com.topcare.petshop.controller.dto.product.request.ProductVariantRequestPostDTO;
import com.topcare.petshop.controller.dto.product.response.ProductVariantResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long variantCode;

    @Column(nullable = false)
    private String variantTitle;

    @OneToMany
    @JoinColumn(name = "product_variant_id", nullable = false)
    private List<ProductImage> images;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Double discount;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Boolean available;


    public ProductVariant(ProductVariantRequestPostDTO productVariant) {
        setVariantCode(productVariant.variantCode());
        setVariantTitle(productVariant.variantTitle());
        setPrice(productVariant.price());
//        setImages(productVariant.images());
        setDiscount(productVariant.discount());
        setStock(productVariant.amountStock());

        if(stock > 0){
            setAvailable(true);
        }else {
            setAvailable(false);
        }
    }

    public ProductVariantResponseDTO toDTO(){

        Boolean isStockAvailable = stock > 0;
        Double discountPrice = price - (price * (discount/100));

        return new ProductVariantResponseDTO(
                getVariantTitle(),
                getVariantCode(),
                getPrice(),
                discountPrice,
                isStockAvailable,
                getImages()
        );
    }
}
