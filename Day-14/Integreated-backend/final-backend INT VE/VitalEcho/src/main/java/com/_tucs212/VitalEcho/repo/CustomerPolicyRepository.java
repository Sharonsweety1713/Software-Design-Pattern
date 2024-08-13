package com._tucs212.VitalEcho.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com._tucs212.VitalEcho.model.CustomerPolicy;

// @Repository
// public interface CustomerPolicyRepository extends JpaRepository<CustomerPolicy, Long> {
//     List<CustomerPolicy> findByCustomerEmail(String email);
// }

@Repository
public interface CustomerPolicyRepository extends JpaRepository<CustomerPolicy, Long> {
    @Query("SELECT p FROM CustomerPolicy p WHERE p.action = true")
    List<CustomerPolicy> findVerifiedPolicies();
}

