package com.topcare.petshop.repository;

import com.topcare.petshop.entity.Product;
import com.topcare.petshop.entity.ProductCategory;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.ReadWriteLock;
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
    @Query(value = "SELECT product_id FROM product_categories WHERE categories_id in :categories GROUP BY product_id HAVING COUNT(DISTINCT categories_id) = :categoriSize;", nativeQuery = true)
    List<Long> findAllByCategoryIds(@Param("categories") List<Long> categories, Integer categoriSize);
    Page<Product> findAllByIdIn(List<Long> productIds, Pageable pageable);
}



