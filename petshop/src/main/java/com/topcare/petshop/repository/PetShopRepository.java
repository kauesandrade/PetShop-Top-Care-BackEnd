package com.topcare.petshop.repository;

import com.topcare.petshop.entity.Petshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetShopRepository extends JpaRepository<Petshop, Long> {
}
