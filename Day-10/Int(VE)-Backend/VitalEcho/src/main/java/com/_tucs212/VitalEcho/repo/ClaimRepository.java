package com._tucs212.VitalEcho.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com._tucs212.VitalEcho.model.Claim;

// @Repository
// public interface ClaimRepository extends JpaRepository<Claim, Long> {
// }

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
}

