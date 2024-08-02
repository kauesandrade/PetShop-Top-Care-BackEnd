package com.topcare.petshop.repository;

import com.topcare.petshop.entity.ServiceVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceVariantRepository extends JpaRepository<ServiceVariant, Long> {
}
