
package com._tucs212.VitalEcho_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com._tucs212.VitalEcho_backend.model.Policy;
import com._tucs212.VitalEcho_backend.service.PolicyService;

import java.util.List;

@RestController
@RequestMapping("/policies")
public class PolicyController {
    @Autowired
    private PolicyService policyService;

    @PostMapping
    public ResponseEntity<Policy> createPolicy(@RequestBody Policy policy) {
        return ResponseEntity.ok(policyService.savePolicy(policy));
    }

    @GetMapping
    public ResponseEntity<List<Policy>> getAllPolicies() {
        return ResponseEntity.ok(policyService.getAllPolicies());
    }

    @GetMapping("/{policyID}")
    public ResponseEntity<Policy> getPolicyById(@PathVariable Long policyID) {
        return ResponseEntity.ok(policyService.findPolicyById(policyID));
    }
    @DeleteMapping("/{policyID}")
    public ResponseEntity<String> deletePolicyById(@PathVariable Long policyID) {
        policyService.deletePolicyById(policyID);
        return ResponseEntity.ok("Policy deleted successfully");  // Return success message
    }
}

