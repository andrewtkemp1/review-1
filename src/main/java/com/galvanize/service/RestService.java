package com.galvanize.service;

import com.galvanize.entity.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {
    RestTemplate restTemplate;

    public RestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean validate(String imdbId){
        ResponseEntity<Movie> returnValue = restTemplate.getForEntity("/api/movies" +imdbId, Movie.class);
        boolean valid = returnValue.getBody() != null;
        return valid;
    }

    public Movie getMovieInfo(String imdbId) {
        return (Movie) restTemplate.getForEntity("/api/movies" +imdbId, Model.class).getBody();
    }
}
