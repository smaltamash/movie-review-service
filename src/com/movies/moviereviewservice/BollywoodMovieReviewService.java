package com.movies.moviereviewservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BollywoodMovieReviewService implements MovieReviewService {

    List<Movie> movies = new ArrayList<>();
    List<String> users = new ArrayList<>();
    List<Review> reviews = new ArrayList<>();

    @Override
    public void addMovie(String movieName, int releasedYear, String... genre) {
        Movie movie = new Movie();
        movie.setMovieName(movieName);
        movie.setReleasedYear(releasedYear);
        movie.setGenre(Arrays.asList(genre));
        movies.add(movie);
    }

    @Override
    public void addUser(String user) {
        users.add(user);
    }

    @Override
    public void addReview(String reviewerName, String movieName, int reviewerRating) throws Exception {
        boolean reviewFlag = true;
        boolean reviewFlag2 = true;
        boolean reviewFlag3 = true;
        int movieIndex = 0;
        int movieIndexReview = 0;
        for(Movie m : movies) {
            if(m.getMovieName().equals(movieName)) {
                reviewFlag = false;
                break;
            }
            movieIndex++;
        }
        for(Review r : reviews) {
            if(r.getMovieName().equals(movieName)) {
                reviewFlag2 = false;
                break;
            }
            movieIndexReview++;
        }
        if(reviewFlag2) {
            Review review = new Review();
            review.setMovieName(movieName);
            List<String> rName = new ArrayList<>();
            rName.add(reviewerName);
            review.setReviewerName(rName);
            List<Integer> rRating = new ArrayList<>();
            rRating.add(reviewerRating);
            review.setReviewerRating(rRating);
            reviews.add(review);
            movies.get(movieIndex).setReview(review);
            reviewFlag3 = false;
        }
        if(reviewFlag && reviewFlag2) {
            throw new Exception("Movie not available in record so cannot add Review.");
        }
        if(reviewFlag3) {
            reviews.get(movieIndexReview).getReviewerName().add(reviewerName);
            reviews.get(movieIndexReview).getReviewerRating().add(reviewerRating);
            movies.get(movieIndex).setReview(reviews.get(movieIndexReview));
        }
    }
    public void displayData() {
        int index = 0;
        System.out.println("Data Displayed Below:-");
        for(Movie m : movies) {
            System.out.println(m.getMovieName() + " " + m.getReleasedYear() + " " + m.getGenre() + " " + m.getReview().getReviewerName() + " " + m.getReview().getReviewerRating());
        }
    }

    public void topInYear(int year) {
        int index = 0;
        int max = 0;
        int maxIndex = 0;
        for(Movie m : movies) {
            if(m.getReleasedYear() == year) {
                int sum = 0;
                for(Integer r : m.getReview().getReviewerRating()) {
                    sum+=r;
                }
                if(max < sum){
                    max = sum;
                    maxIndex = index;
                }
            }
            index++;
        }
        System.out.println("Top in Year " + year + "\n" + movies.get(maxIndex).getMovieName() + " - " + max);
    }

    public void averageReviewYear(int year) {
        float avgSum = 0.0f;
        int max = 0;
        for(Movie m : movies) {
            if(m.getReleasedYear() == year) {
                int sum = 0;
                int i = 0;
                for(Integer r : m.getReview().getReviewerRating()) {
                    sum+=r;
                    i++;
                }
                if(max < sum) {
                    max = sum;
                    avgSum = (float)max/i;
                }
            }
        }
        System.out.println("Average Rating in Year " + year + " is " + avgSum + " ratings.");
    }
}
