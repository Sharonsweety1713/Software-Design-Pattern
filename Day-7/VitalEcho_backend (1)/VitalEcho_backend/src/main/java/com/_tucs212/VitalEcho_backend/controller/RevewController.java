package com._tucs212.VitalEcho_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com._tucs212.VitalEcho_backend.model.Reviews;
import com._tucs212.VitalEcho_backend.service.ReviewService;

@RestController
@RequestMapping("/review")
public class RevewController {

    @Autowired
    public ReviewService rs;

    @GetMapping
    public List<Reviews>getRev()
    {
        return rs.getAllReview();
    }
    @PostMapping
    public Reviews addRev(@RequestBody Reviews reviews)
    {
       return  rs.addReview(reviews);
    }
}
