package com.galvanize.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.entity.Review;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void postReview() throws Exception {
        Review expected = new Review();
        String json = objectMapper.writeValueAsString(expected);
        expected.setReviewId(1L);
        when(reviewService.postReview(any(Review.class))).thenReturn(expected);
        mvc.perform(post("/api/reviews").content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.reviewId").value(expected.getReviewId()));

    }

    @Test
    public void getAllReviews() throws Exception {
        Review expected = new Review();
        expected.setReviewId(1L);
        ArrayList<Review> review = new ArrayList<>();
        review.add(expected);
        when(reviewService.getAllReviews()).thenReturn(review);
        mvc.perform(get("/api/reviews"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].reviewId").value(expected.getReviewId()));
    }

    @Test
    public void getMovieReviewByimdbId() throws Exception {
        Review expected = new Review();
        expected.setReviewId(1L);
        when(reviewService.findReviewByImdbId("tt0241527")).thenReturn(expected);
        mvc.perform(get("/api/reviews/imdbId/tt0241527"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.imdbId").value(expected.getImdbId()))
                .andExpect(jsonPath("$.reviewId").value(expected.getReviewId()));
    }
}
