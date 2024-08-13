package com._tucs212.VitalEcho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com._tucs212.VitalEcho.model.ContactUs;
import com._tucs212.VitalEcho.services.ContactUsService;

@RestController
@RequestMapping("/contact")
@CrossOrigin(origins = "http://localhost:5173")
public class ContactUsController {

    @Autowired
    private ContactUsService contactUsService;

    @PostMapping
    public ResponseEntity<ContactUs> createContactUs(@RequestBody ContactUs contactUs) {
        ContactUs savedContactUs = contactUsService.saveContactUs(contactUs);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedContactUs);
    }
}
