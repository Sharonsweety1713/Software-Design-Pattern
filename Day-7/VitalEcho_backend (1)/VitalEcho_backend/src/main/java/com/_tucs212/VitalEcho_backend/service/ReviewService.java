package com._tucs212.VitalEcho_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._tucs212.VitalEcho_backend.model.Reviews;
import com._tucs212.VitalEcho_backend.repo.ReviewRepo;

@Service
public class ReviewService {
    @Autowired
   public ReviewRepo rr;
    

    public List<Reviews> getAllReview()
    {
        return rr.findAll();
    }

    public Reviews addReview(Reviews rev)
    {
        return rr.save(rev);
    }
    
}
