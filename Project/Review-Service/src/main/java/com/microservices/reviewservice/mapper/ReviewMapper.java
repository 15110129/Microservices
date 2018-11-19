package com.microservices.reviewservice.mapper;

import com.microservices.reviewservice.entity.Review;
import com.microservices.reviewservice.model.ReviewDTO;

public class ReviewMapper {
    static public ReviewDTO toReviewDTO(Review review){
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setId(review.getId());
        reviewDTO.setProductId(review.getProductId());
        reviewDTO.setUsername(review.getUsername());
        reviewDTO.setContent(review.getContent());
        reviewDTO.setDateTime(review.getDateTime());

        return reviewDTO;
    }

    static public Review toReview(ReviewDTO reviewDTO){
        Review review = new Review();
        review.setId(reviewDTO.getId());
        review.setProductId(reviewDTO.getProductId());
        review.setUsername(reviewDTO.getUsername());
        review.setContent(reviewDTO.getContent());
        review.setDateTime(reviewDTO.getDateTime());

        return review;
    }
}
