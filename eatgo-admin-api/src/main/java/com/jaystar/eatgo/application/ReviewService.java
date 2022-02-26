package com.jaystar.eatgo.application;

import com.jaystar.eatgo.domain.Review;

import java.util.List;

public class ReviewService {
    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }
}
