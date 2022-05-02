package com.example.olioht;

import java.util.ArrayList;
import java.util.List;

public class ReviewSingleton {
    private List<Review> Reviews;

    private ReviewSingleton() {
        Reviews = new ArrayList<>();
    }

    public void AddReview(String username, String reviewtext) {

        Reviews.add(new Review(username, reviewtext));
    }

    public List<Review> getReviews() {
        return (Reviews);
    }

    private static ReviewSingleton ReviewsBase;

    public static ReviewSingleton get() {
        if (ReviewsBase == null) {
            ReviewsBase = new ReviewSingleton();
        }
        return (ReviewsBase);
    }
}

/* tässä singletonissa tallennetaan/haetaan arvosteluja Reviews array lististä. */