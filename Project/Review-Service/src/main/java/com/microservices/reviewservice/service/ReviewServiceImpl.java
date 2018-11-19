package com.microservices.reviewservice.service;

import com.microservices.reviewservice.entity.Review;
import com.microservices.reviewservice.exception.ReviewNotFoundException;
import com.microservices.reviewservice.mapper.ReviewMapper;
import com.microservices.reviewservice.model.ReviewDTO;
import com.microservices.reviewservice.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public List<ReviewDTO> findReviewByProductId(Long productId) {
        List<Review> reviews = reviewRepository.findReviewByProductId(productId);
        List<ReviewDTO> reviewDTOS = new ArrayList<>();
        for (Review review : reviews) {
            ReviewDTO reviewDTO = ReviewMapper.toReviewDTO(review);
            System.out.println(reviewDTO.getId());
            reviewDTOS.add(reviewDTO);
        }
        return reviewDTOS;
    }

    @Override
    public ReviewDTO findReviewById(Long id) {
        Optional<Review> review = reviewRepository.findById(id);
        if (!review.isPresent())
            throw new ReviewNotFoundException("Review id " + id + " not existed");
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO = ReviewMapper.toReviewDTO(review.get());

        return reviewDTO;
    }

    @Override
    public ReviewDTO insertReview(ReviewDTO reviewDTO) {
        if (reviewDTO == null)
            throw new ReviewNotFoundException("Object is null");
        Review review;
        reviewDTO.setDateTime(LocalDateTime.now());
        review = ReviewMapper.toReview(reviewDTO);
        reviewDTO = ReviewMapper.toReviewDTO(reviewRepository.save(review));

        return reviewDTO;
    }

    @Override
    public ReviewDTO updateReview(Long id, ReviewDTO reviewDTO) {
        Optional<Review> review = reviewRepository.findById(id);
        if (!review.isPresent())
            throw new ReviewNotFoundException("Review id " + id + " not existed");
        if(reviewDTO.getContent().equals(""))
            throw new ReviewNotFoundException("Content must be not null");
        review.get().setContent(reviewDTO.getContent());
        reviewDTO.setId(review.get().getId());
        reviewDTO = ReviewMapper.toReviewDTO(reviewRepository.save(review.get()));

        return reviewDTO;
    }

    @Override
    public boolean deleteReview(Long id) {
        Optional<Review> review = reviewRepository.findById(id);
        if (!review.isPresent())
            throw new ReviewNotFoundException("Review id " + id + " not existed");
        reviewRepository.delete(review.get());
        return (!reviewRepository.existsById(id));
    }
}