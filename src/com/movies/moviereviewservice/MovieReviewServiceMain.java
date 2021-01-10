package com.movies.moviereviewservice;

public class MovieReviewServiceMain {

    public static void main(String[] args) {
        BollywoodMovieReviewService bmrs = new BollywoodMovieReviewService();
        bmrs.addMovie("Don", 2006, "Action", "Comedy");
        bmrs.addMovie("Tiger", 2008, "Drama");
        bmrs.addMovie("Padmavaat", 2006, "Comedy");
        bmrs.addMovie("Guru", 2006, "Drama");
        bmrs.addMovie("Metro", 2006, "Romance");
        bmrs.addUser("SRK");
        bmrs.addUser("Salman");
        bmrs.addUser("Deepika");
        bmrs.addUser("Ranbir");
        System.out.println("Hello 4");
        try {
            bmrs.addReview("SRK", "Don", 2);
            bmrs.addReview("Salman", "Don", 5);
            bmrs.addReview("Deepika", "Don", 9);
            bmrs.addReview("Deepika", "Guru", 6);
            bmrs.addReview("SRK", "Tiger", 7);
            bmrs.addReview("Ranbir", "Padmavaat", 4);
            bmrs.addReview("Salman", "Metro", 9);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        bmrs.topInYear(2006);
        bmrs.averageReviewYear(2006);
        bmrs.displayData();
    }
}
