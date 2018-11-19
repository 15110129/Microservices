package com.microservices.reviewservice.service;

import com.microservices.reviewservice.model.ReviewDTO;

import java.util.List;

public interface ReviewService {
    List<ReviewDTO> findReviewByProductId(Long productId);
    ReviewDTO findReviewById(Long id);
    ReviewDTO insertReview(ReviewDTO reviewDTO);
    ReviewDTO updateReview(Long id, ReviewDTO reviewDTO);
    boolean deleteReview(Long id);
}
