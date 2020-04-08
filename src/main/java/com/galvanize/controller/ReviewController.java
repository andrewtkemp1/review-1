package com.galvanize.controller;

import com.galvanize.entity.Review;
import com.galvanize.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    ReviewService reviewService;

    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @PostMapping
    public Review createMovie(@RequestBody Review input){
        return reviewService.postReview(input);
    }

    @GetMapping
    public List<Review> getAllReviews(){
        return reviewService.getAllReviews();
    }
}
