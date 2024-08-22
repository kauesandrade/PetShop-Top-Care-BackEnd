package com.topcare.petshop.repository;


import com.topcare.petshop.entity.BrandImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandImageRepository extends JpaRepository<BrandImage, Long> {
}
