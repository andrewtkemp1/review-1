package com.galvanize.entity;

import javax.persistence.*;
import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;

@javax.persistence.Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private long review_id;
    @Column(name = "user_email")
    private String user_email;
    @Column(name = "imdb_id")
    private String imdb_id;
    @Column(name = "title")
    private String title;
    @Column(name = "stars")
    private String stars;
    @Column(name = "detail")
    private String detail;
    @Column(name = "date")
    private Timestamp date;
    public Review() {}
    public Review(long review_id, String user_email, String imdb_id, String title, String stars, String detail, Timestamp date) {
        this.review_id = review_id;
        this.user_email = user_email;
        this.imdb_id = imdb_id;
        this.title = title;
        this.stars = stars;
        this.detail = detail;
        this.date = date;
    }
    public Review(String user_email, String imdb_id, String title, String stars, String detail) {
        this.user_email = user_email;
        this.imdb_id = imdb_id;
        this.title = title;
        this.stars = stars;
        this.detail = detail;
    }

    public long getReview_id() {
        return review_id;
    }

    public void setReview_id(long review_id) {
        this.review_id = review_id;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public  String getStars() {
        return stars;
    }

    public void setStars(String  stars) {
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
        if (!(o instanceof Review)) return false;
        Review review = (Review) o;
        return getReview_id() == review.getReview_id() &&
                getStars() == review.getStars() &&
                Objects.equals(user_email, review.user_email) &&
                Objects.equals(getImdb_id(), review.getImdb_id()) &&
                Objects.equals(getTitle(), review.getTitle()) &&
                Objects.equals(getDetail(), review.getDetail()) &&
                Objects.equals(getDate(), review.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReview_id(), user_email, getImdb_id(), getTitle(), getStars(), getDetail(), getDate());
    }

    @Override
    public String toString() {
        return "Review{" +
                "review_id=" + review_id +
                ", user_email='" + user_email + '\'' +
                ", imdb_id='" + imdb_id + '\'' +
                ", title='" + title + '\'' +
                ", stars=" + stars +
                ", detail='" + detail + '\'' +
                ", date=" + date +
                '}';
    }

}
