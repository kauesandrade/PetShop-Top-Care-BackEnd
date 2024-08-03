package com.topcare.petshop.repository;

import com.topcare.petshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByCode(Long code);
    void deleteByCode(Long code);
    boolean existsByCode(Long code);


}
