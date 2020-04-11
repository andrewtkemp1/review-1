package com.galvanize.service;

import com.galvanize.entity.Review;
import com.galvanize.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    public Review postReview(Review review) {
        return reviewRepository.save(review);
    }

    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    public Review findReviewByImdbId(String imdbId) {
        return reviewRepository.findReviewByImdbId(imdbId);
    }

    public Review updateMovieWithStarRating(long reviewId, Review rating) {
        Review newReview = updateMovieWithStarRating(reviewId, rating);
//        newReview.update(newReview);
        return postReview(newReview);
    }

    public boolean deleteById (long reviewId){
        return reviewRepository.deleteById(reviewId);
    }
}