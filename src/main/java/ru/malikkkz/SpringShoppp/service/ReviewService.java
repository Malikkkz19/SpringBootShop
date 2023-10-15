package ru.malikkkz.SpringShoppp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.malikkkz.SpringShoppp.entity.Product;
import ru.malikkkz.SpringShoppp.entity.Review;
import ru.malikkkz.SpringShoppp.entity.User;
import ru.malikkkz.SpringShoppp.repository.ReviewRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void addReview(User user, Product product, Integer rating, String reviewText) {
        Review review = new Review();
        review.setReviewDate(Timestamp.valueOf(LocalDateTime.now()));
        review.setUser(user);
        review.setProduct(product);
        review.setRating(rating);
        review.setReviewText(reviewText);
        review.setStatus(false);


        reviewRepository.save(review);
    }
}
