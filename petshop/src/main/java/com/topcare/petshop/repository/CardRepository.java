package com.topcare.petshop.repository;

import com.topcare.petshop.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    Optional<Card> findByCustomer_IdAndMainCardIsTrue(Long id);
    Optional<Card> findFirstByCustomer_Id(Long id);

}
