package com.topcare.petshop.Repository;

import com.topcare.petshop.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Customer, Long> {

    Optional<User> findByEmail(String email);

}
