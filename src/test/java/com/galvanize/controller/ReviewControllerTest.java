package com.galvanize.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.entity.Review;
import com.galvanize.service.RestService;
import com.galvanize.service.ReviewService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ReviewControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    ReviewService reviewService;

    @MockBean
    RestService restService;
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void postReview() throws Exception {
        Review expected = new Review();
        expected.setImdb_id("tt0241527");
        String json = objectMapper.writeValueAsString(expected);
        when(restService.validate(anyString())).thenReturn(true);
        when(reviewService.postReview(any(Review.class))).thenReturn(expected);
        mvc.perform(post("/api/reviews").content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(expected));
    }

    @Test
    public void getAllReviews() throws Exception {
        Review expected = new Review();
        expected.setImdb_id("tt0241527");
        ArrayList<Review> review = new ArrayList<>();
        review.add(expected);
        when(restService.validate(anyString())).thenReturn(true);
        when(reviewService.getAllReviews()).thenReturn(review);
        mvc.perform(get("/api/reviews?title=startrek&apiKey=656a57f5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0].rating").value(expected.getStars()))
                .andExpect(jsonPath("$[0].imdbId").value(expected.getImdb_id()))
                .andExpect(jsonPath("$[0].reviewId").value(expected.getReview_id()));
    }

    @Test
    public void getMovieReviewsByimdbId() throws Exception {
        Review expected = new Review();
        expected.setReview_id(1L);
        when(reviewService.findReviewByImdbId("tt0241527")).thenReturn(expected);
        mvc.perform(get("/api/reviews/imdbId/tt0241527"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.imdbId").value(expected.getImdb_id()))
                .andExpect(jsonPath("$.reviewId").value(expected.getReview_id()));
    }


    @Test
    public void updateMovie() throws Exception {
        Review expected = new Review();
        expected.setReview_id(1L);
        String json = objectMapper.writeValueAsString(expected);
        when(reviewService.updateMovieWithStarRating(anyLong(), any(Review.class))).thenReturn(expected);
        mvc.perform(put("/api/reviews/rating/1").content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.reviewId").value(expected.getReview_id()));
    }

    @Test
    public void deleteReviewById() throws Exception {
        when(reviewService.deleteById(anyLong())).thenReturn(true);
        mvc.perform(delete("/api/reviews/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(true));
    }
}
