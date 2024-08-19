package com.topcare.petshop.repository;

import com.topcare.petshop.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {

    Page<Service> findAllByIdIn(List<Long> serviceIds, Pageable pageable);
}
