
package com._tucs212.VitalEcho_backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com._tucs212.VitalEcho_backend.model.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
}
