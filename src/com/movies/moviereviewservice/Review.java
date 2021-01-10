package com.movies.moviereviewservice;

import java.util.List;

public class Review {

    String movieName;
    List<String> reviewerName;
    List<Integer> reviewerRating;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public List<String> getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(List<String> reviewerName) {
        this.reviewerName = reviewerName;
    }

    public List<Integer> getReviewerRating() {
        return reviewerRating;
    }

    public void setReviewerRating(List<Integer> reviewerRating) {
        this.reviewerRating = reviewerRating;
    }
}
