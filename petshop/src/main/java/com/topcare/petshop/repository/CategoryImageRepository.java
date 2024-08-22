package com.topcare.petshop.repository;

import com.topcare.petshop.entity.CategoryImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryImageRepository extends JpaRepository<CategoryImage, Long> {
}
