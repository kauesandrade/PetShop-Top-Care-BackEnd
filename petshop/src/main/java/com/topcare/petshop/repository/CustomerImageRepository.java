package com.topcare.petshop.repository;

import com.topcare.petshop.entity.CustomerImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerImageRepository extends JpaRepository<CustomerImage, Long> {
}
