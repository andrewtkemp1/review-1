package com.galvanize.service;

import com.galvanize.entity.Review;
import com.galvanize.repository.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Table;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ReviewServiceTest {
    Review review;
    @MockBean
    ReviewRepository reviewRepository;

    @Autowired
    ReviewService reviewService;
    @BeforeEach
    void setup() {
       review = new Review("xyz@xyz.com", "tt0241527", "Harry Potter and the Sorcerer's Stone", "4", "hello");
       review.setReview_id(1L);
       review.setDate(new Timestamp(System.currentTimeMillis()));
    }
    @Test
    public void postReview(){
        // long review_id, String user_email, String imdb_id, String title, String stars, String detail, Timestamp date
        Review expected = new Review(1L, "xyz@xyz.com", "tt0241527", "Harry Potter and the Sorcerer's Stone","4", "hello", new Timestamp(System.currentTimeMillis()));
        when(reviewRepository.save(any(Review.class))).thenReturn(expected);
        assertEquals(expected, reviewService.postReview(review));
    }

    @Test
    public void getAllReviews(){
        Review expected = new Review(1L, "xyz@xyz.com", "tt0241527", "Harry Potter and the Sorcerer's Stone","4", "hello", new Timestamp(System.currentTimeMillis()));
        ArrayList<Review> expectedReviews = new ArrayList<>();
        expectedReviews.add(expected);
        when(reviewRepository.findAll()).thenReturn(expectedReviews);
        assertEquals(expectedReviews, reviewService.getAllReviews());
    }

    @Test
    public void getMovieByImdbId(){
        Review expected = new Review(1L, "xyz@xyz.com", "tt0241527", "Harry Potter and the Sorcerer's Stone","4", "hello", new Timestamp(System.currentTimeMillis()));
        when(reviewRepository.findReviewByImdbId(anyString())).thenReturn(expected);
        assertEquals(expected, reviewService.findReviewByImdbId("tt0241527"));
    }

    @Test
    public void updateMovieWithStarRating(){
        ReviewService reviewService = new ReviewService(reviewRepository);
        Review expected = reviewService.postReview(review);
        when(reviewService.findReviewByImdbId(anyString())).thenReturn(expected);
        assertEquals(expected, reviewService.findReviewByImdbId("tt0241527"));
    }

    @Test
    public void deleteMovie(){
        when(reviewRepository.deleteById(anyLong())).thenReturn(true);
        assertTrue(reviewService.deleteById(1L));
    }
}