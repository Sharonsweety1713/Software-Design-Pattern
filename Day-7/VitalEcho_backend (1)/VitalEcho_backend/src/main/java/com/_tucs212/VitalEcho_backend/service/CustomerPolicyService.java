package com._tucs212.VitalEcho_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com._tucs212.VitalEcho_backend.model.Customer;
import com._tucs212.VitalEcho_backend.model.CustomerPolicy;
import com._tucs212.VitalEcho_backend.model.Policy;
import com._tucs212.VitalEcho_backend.repo.CustomerPolicyRepository;
import com._tucs212.VitalEcho_backend.repo.CustomerRepository;
import com._tucs212.VitalEcho_backend.repo.PolicyRepository;
import java.util.Optional;

@Service
public class CustomerPolicyService {
    @Autowired
    private CustomerPolicyRepository customerPolicyRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PolicyRepository policyRepository;

    public CustomerPolicy saveCustomerPolicy(CustomerPolicy customerPolicy) {
       
        Optional<Customer> customerOpt = customerRepository.findById(customerPolicy.getCustomer().getEmail());
        Optional<Policy> policyOpt = policyRepository.findById(customerPolicy.getPolicy().getPolicyID());

        if (!customerOpt.isPresent() || !policyOpt.isPresent()) {
            throw new IllegalArgumentException("Customer or Policy not found");
        }

       
        Customer customer = customerOpt.get();
        Policy policy = policyOpt.get();

        customerPolicy.setCustomer(customer);
        customerPolicy.setPolicy(policy);

        
        customerPolicy.setPolicyName(policy.getPolicyName());
        customerPolicy.setPolicyDuration(policy.getPolicyDuration());
        customerPolicy.setPolicyAmount(policy.getPolicyAmount());

        return customerPolicyRepository.save(customerPolicy);
    }

    public CustomerPolicy findCustomerPolicyById(Long policyNo) {
                return customerPolicyRepository.findById(policyNo).orElse(null);
            }
        
            public CustomerPolicy updateCustomerPolicy(CustomerPolicy customerPolicy) {
                return customerPolicyRepository.save(customerPolicy);
            }

    
}





