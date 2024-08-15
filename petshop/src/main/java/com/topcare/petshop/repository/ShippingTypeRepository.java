package com.topcare.petshop.repository;

import com.topcare.petshop.entity.ShippingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingTypeRepository extends JpaRepository<ShippingType, Long> {
}
