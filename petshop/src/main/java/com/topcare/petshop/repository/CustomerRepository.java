package com.topcare.petshop.repository;

import com.topcare.petshop.entity.Card;
import com.topcare.petshop.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Card> findByIdAndMainCardIsTrue(Long id);
}
