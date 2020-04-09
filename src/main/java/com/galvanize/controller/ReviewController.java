package com.galvanize.controller;

import com.galvanize.entity.Review;
import com.galvanize.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    ReviewService reviewService;
//    RestTemplate restTemplate;


    private static  String apiKey = "&apikey=656a57f5";
    private static  String url = "http://www.omdbapi.com/";
    private static String SEARCH_BASE = url + "&type=movie&plot=full&s=";
    private static String IMDBID_BASE = url + "&plot=full&1=";

    public ReviewController(
                            ReviewService reviewService) {
//        this.restTemplate = restTemplate;
        this.reviewService = reviewService;

    }




    @PostMapping
    public Review createMovie(@RequestBody Review input){
        return reviewService.postReview(input);
    }

    @GetMapping()
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
