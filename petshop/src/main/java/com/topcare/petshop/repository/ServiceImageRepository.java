package com.topcare.petshop.repository;

import com.topcare.petshop.entity.ServiceImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceImageRepository extends JpaRepository<ServiceImage, Long> {
}
