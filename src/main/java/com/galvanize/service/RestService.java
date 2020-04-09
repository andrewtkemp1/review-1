package com.galvanize.service;

import com.galvanize.entity.Review;
import com.galvanize.model.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {
    RestTemplate restTemplate;

    public RestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean validate(String imdbId){
        ResponseEntity<Model> returnValue = restTemplate.getForEntity("/api/movies" +imdbId, Model.class);
        boolean valid = returnValue.getBody() != null;
        return valid;
    }

    public Model getMovieInfo(String imdbId) {
        return restTemplate.getForEntity("/api/movies" +imdbId, Model.class).getBody();
    }
}
