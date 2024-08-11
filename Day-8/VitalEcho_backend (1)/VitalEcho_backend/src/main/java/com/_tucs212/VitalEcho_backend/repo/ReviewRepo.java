package com._tucs212.VitalEcho_backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com._tucs212.VitalEcho_backend.model.Reviews;

public interface ReviewRepo extends JpaRepository<Reviews,Long> {
    
}
