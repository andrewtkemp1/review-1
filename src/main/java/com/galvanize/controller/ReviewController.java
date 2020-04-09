package com.galvanize.controller;

import com.galvanize.entity.Review;
import com.galvanize.service.RestService;
import com.galvanize.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    ReviewService reviewService;
    RestService restService;

    public ReviewController(ReviewService reviewService, RestService restService) {
        this.reviewService = reviewService;
        this.restService = restService;
    }

    @PostMapping
    public ResponseEntity<Review> postReview(@RequestBody Review Post){
        if(restService.validate(Post.getImdbId())){
            return ResponseEntity.ok(reviewService.postReview(Post));
        }
        return null;
    }

    @GetMapping
    public List<Review> getAllReviews(){
        return reviewService.getAllReviews();
    }

    @GetMapping("/imdbId/{imdbId}")
    public Review getOneMovieReviewByimdbId(@PathVariable String imdbId){
        return reviewService.findReviewByImdbId(imdbId);
    }

    @PutMapping("/rating/{reviewId}")
    public Review updateMovieReviewWithStarRating(@PathVariable long reviewId, @RequestBody Review review){
        return reviewService.updateMovieWithStarRating(reviewId, review);
    }

    @DeleteMapping("/{id}")
    public boolean updateMovie(@PathVariable long id){
        return reviewService.deleteById(id);
    }
}
