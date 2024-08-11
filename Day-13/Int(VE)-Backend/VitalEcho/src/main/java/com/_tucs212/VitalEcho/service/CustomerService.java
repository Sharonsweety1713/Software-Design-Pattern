package com._tucs212.VitalEcho.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com._tucs212.VitalEcho.model.Customer;
import com._tucs212.VitalEcho.repo.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer findCustomerByEmail(String email) {
        return customerRepository.findByEmail(email).orElse(null);
    }

   
}
