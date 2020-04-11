package com.galvanize.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.transform.Result;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private long movie_id;
    @Column(name = "imdb_id")
    private String imdb_id;
    @Column(name = "actors")
    private String actors;
    @Column(name = "director")
    private String director;
    @Column(name = "title")
    private String title;
    @Column(name = "released")
    private String released;
    @Column(name = "year")
    private String year;
    @Column(name = "stars")
    private long stars;
    @Column(name = "detail")
    private String detail;
    @Column(name = "date")
    private Timestamp date;
    public Movie() {

    }
    public Movie(long movie_id, String imdb_id, String actors, String director, String title, String released, String year, long stars, String detail, Timestamp date) {
        this.movie_id = movie_id;
        this.imdb_id = imdb_id;
        this.actors = actors;
        this.director = director;
        this.title = title;
        this.released = released;
        this.year = year;
        this.stars = stars;
        this.detail = detail;
        this.date = date;
    }
    public Movie(String imdb_id, String actors, String director, String title, String released, String year, long stars, String detail) {
        this.imdb_id = imdb_id;
        this.actors = actors;
        this.director = director;
        this.title = title;
        this.released = released;
        this.year = year;
        this.stars = stars;
        this.detail = detail;
    }
    public long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(long movie_id) {
        this.movie_id = movie_id;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public long getStars() {
        return stars;
    }

    public void setStars(long stars) {
        this.stars = stars;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return getMovie_id() == movie.getMovie_id() &&
                getStars() == movie.getStars() &&
                Objects.equals(getImdb_id(), movie.getImdb_id()) &&
                Objects.equals(getActors(), movie.getActors()) &&
                Objects.equals(getDirector(), movie.getDirector()) &&
                Objects.equals(getTitle(), movie.getTitle()) &&
                Objects.equals(getReleased(), movie.getReleased()) &&
                Objects.equals(getYear(), movie.getYear()) &&
                Objects.equals(getDetail(), movie.getDetail()) &&
                Objects.equals(getDate(), movie.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMovie_id(), getImdb_id(), getActors(), getDirector(), getTitle(), getReleased(), getYear(), getStars(), getDetail(), getDate());
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movie_id +
                ", imdb_id='" + imdb_id + '\'' +
                ", actors='" + actors + '\'' +
                ", director='" + director + '\'' +
                ", title='" + title + '\'' +
                ", released='" + released + '\'' +
                ", year='" + year + '\'' +
                ", stars=" + stars +
                ", detail='" + detail + '\'' +
                ", date=" + date +
                '}';
    }
}
