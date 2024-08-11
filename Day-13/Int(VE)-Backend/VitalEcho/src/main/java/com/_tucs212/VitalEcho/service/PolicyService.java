package com._tucs212.VitalEcho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._tucs212.VitalEcho.model.Policy;
import com._tucs212.VitalEcho.repo.PolicyRepository;


@Service
public class PolicyService {
    @Autowired
    private PolicyRepository policyRepository;

    public Policy savePolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    public Policy findPolicyById(Long policyID) {
        return policyRepository.findById(policyID).orElse(null);
    }

    public void deletePolicyById(Long policyID) {
        policyRepository.deleteById(policyID);
    }
}

