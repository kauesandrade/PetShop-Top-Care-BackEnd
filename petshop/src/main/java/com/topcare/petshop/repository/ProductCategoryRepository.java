package com.topcare.petshop.repository;

import com.topcare.petshop.controller.dto.product.request.ProductRequestPostDTO;
import com.topcare.petshop.entity.ProductCategory;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

    Optional<ProductCategory> findProductCategorieByTitle(String title);

    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM product_category WHERE category_group_id = :id", nativeQuery = true)
    List<ProductCategory> findAllByCategory_group_id(@Param("id") Long id);

}
