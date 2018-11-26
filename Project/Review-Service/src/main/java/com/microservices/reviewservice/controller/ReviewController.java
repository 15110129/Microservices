package com.microservices.reviewservice.controller;

import com.microservices.reviewservice.model.ReviewDTO;
import com.microservices.reviewservice.service.ReviewServiceImpl;
import com.microservices.reviewservice.util.ApiResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ReviewController {
    @Autowired
    ReviewServiceImpl reviewService;

    @GetMapping("/product/{id}")
    public Map<String, ?> findReviewByProductId(@PathVariable Long id) {
        return ApiResponseBuilder.buildContainsData("List Review of Product id " + id, reviewService.findReviewByProductId(id));
    }

//    @GetMapping("/{id}")
//    public Map<String, ?> findReviewById(@PathVariable Long id) {
//        return ApiResponseBuilder.buildContainsData("Review id " + id + " not existed", reviewService.findReviewById(id));
//    }

    @PostMapping
    public Map<String, ?> insertReview(@RequestBody ReviewDTO reviewDTO) {
        ReviewDTO savedReviewtDTO = reviewService.insertReview(reviewDTO);
        return ApiResponseBuilder.buildContainsData(String.format("Inserted Review id " + savedReviewtDTO.getId()), savedReviewtDTO);
    }

    @PutMapping("/{id}")
    public Map<String, ?> updateReview(@PathVariable Long id, @RequestBody ReviewDTO reviewDTO) {
        ReviewDTO savedReviewtDTO = reviewService.updateReview(id, reviewDTO);
        return ApiResponseBuilder.buildContainsData(String.format("Update Review id " + id), savedReviewtDTO);
    }

    @DeleteMapping("/{id}")
    public Map<String, ?> deleteReview(@PathVariable Long id) {
        boolean success = reviewService.deleteReview(id);
        if (success)
            return ApiResponseBuilder.buildSuccess(String.format("Delete Review id " + id + " success"));
        else return ApiResponseBuilder.buildSuccess(String.format("Delete Review id " + id + " fail"));
    }
}
