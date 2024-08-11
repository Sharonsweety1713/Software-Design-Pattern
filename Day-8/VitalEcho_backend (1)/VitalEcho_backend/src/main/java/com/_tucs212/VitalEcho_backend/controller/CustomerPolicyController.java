
package com._tucs212.VitalEcho_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com._tucs212.VitalEcho_backend.model.CustomerPolicy;
import com._tucs212.VitalEcho_backend.service.CustomerPolicyService;


@RestController
@RequestMapping("/customer-policies")
public class CustomerPolicyController {
    @Autowired
    private CustomerPolicyService customerPolicyService;

    @PostMapping
    public ResponseEntity<CustomerPolicy> createCustomerPolicy(@RequestBody CustomerPolicy customerPolicy) {
        try {
            CustomerPolicy savedCustomerPolicy = customerPolicyService.saveCustomerPolicy(customerPolicy);
            return ResponseEntity.ok(savedCustomerPolicy);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
     
    @PutMapping("/{policyNo}/action")
        public ResponseEntity<CustomerPolicy> updateCustomerPolicyAction(@PathVariable Long policyNo, @RequestBody CustomerPolicy updatedPolicy) {
            CustomerPolicy existingPolicy = customerPolicyService.findCustomerPolicyById(policyNo);
            if (existingPolicy != null) {
                existingPolicy.setAction(updatedPolicy.isAction());
                return ResponseEntity.ok(customerPolicyService.updateCustomerPolicy(existingPolicy));
            } else {
                return ResponseEntity.notFound().build();
            }
        }

    // @GetMapping
    // public List<CustomerPolicy> getAllCustomerPolicies() {
    //     return customerPolicyService.getAllCustomerPolicies();
    // }
}
