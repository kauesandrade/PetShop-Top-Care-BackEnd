package com.topcare.petshop.repository;

import com.topcare.petshop.entity.DeliveryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryStatusRepository extends JpaRepository<DeliveryStatus, Long> {
}
