package com._tucs212.VitalEcho_backend.controller;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com._tucs212.VitalEcho_backend.model.Customer;
import com._tucs212.VitalEcho_backend.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/signup")
    public ResponseEntity<Customer> signup(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.saveCustomer(customer));
    }

    @GetMapping("/{email}")
    public ResponseEntity<Customer> getCustomerByEmail(@PathVariable String email) {
        return ResponseEntity.ok(customerService.findCustomerByEmail(email));
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginDetails) {
        boolean isAuthenticated = customerService.authenticateCustomer(loginDetails.get("name"), loginDetails.get("password"));
        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid name or password");
        }
    }

}
