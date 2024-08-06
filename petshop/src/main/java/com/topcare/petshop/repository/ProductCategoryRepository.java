package com.topcare.petshop.repository;

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
    List<ProductCategory> findAllByCategoryGroup_Id(Long id);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM product_categories WHERE categories_id = :id", nativeQuery = true)
    void deleteRelationProductByCategoryId(@Param("id") Long id);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM product_category WHERE id = :id", nativeQuery = true)
    void deleteById(@Param("id") Long id);


}

