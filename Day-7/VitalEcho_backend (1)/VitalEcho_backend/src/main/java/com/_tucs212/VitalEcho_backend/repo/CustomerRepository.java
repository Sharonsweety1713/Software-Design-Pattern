
package com._tucs212.VitalEcho_backend.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com._tucs212.VitalEcho_backend.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

   
    Optional<Customer> findByNameAndPassword(String name, String password);
}

