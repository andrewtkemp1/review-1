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

    @GetMapping("/imdbId/{imdbId}")
    public Review getOneMovieReviewByimdbId(@PathVariable String imdbId){
        return reviewService.findReviewByImdbId(imdbId);
    }

//    @PutMapping("/rating/{movieId}")
//    public Movie updateMovieWithStarRating(@PathVariable long movieId, @RequestBody Movie movie){
//        return movieService.updateMovieWithStarRating(movieId, movie);
//    }

    @DeleteMapping("/{id}")
    public boolean updateMovie(@PathVariable long id){
        return reviewService.deleteById(id);
    }
}
