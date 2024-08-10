package com.topcare.petshop.repository;

import com.topcare.petshop.entity.Product;
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
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByCode(Long code);
    void deleteByCode(Long code);
    boolean existsByCode(Long code);

    List<Product> findByCategoriesContains(ProductCategory productCategory);

    @Modifying
    @Transactional
    @Query(value = "SELECT product_id FROM product_categories WHERE categories_id IN :categories", nativeQuery = true)
    List<Long> getAllByCategoriesIds(@Param("categories") List<Long> categories);


}
