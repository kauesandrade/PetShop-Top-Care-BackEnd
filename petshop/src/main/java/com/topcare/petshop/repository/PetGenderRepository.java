package com.topcare.petshop.repository;

import com.topcare.petshop.entity.PetGender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetGenderRepository extends JpaRepository<PetGender, Long> {
}
