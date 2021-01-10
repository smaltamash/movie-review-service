package com.movies.moviereviewservice;

import java.util.List;

public interface MovieReviewService {

    // method to add movie
    public void addMovie(String movieName, int releasedYear, String... genre);

    // method to add user
    public void addUser(String user);

    // method to add review
    public void addReview(String reviewerName, String movieName, int reviewerRating) throws Exception;
}
