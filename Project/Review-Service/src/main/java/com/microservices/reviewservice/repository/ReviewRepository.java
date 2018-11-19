package com.microservices.reviewservice.repository;

import com.microservices.reviewservice.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findReviewByProductId(Long productId);
}
