package ru.malikkkz.SpringShoppp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.malikkkz.SpringShoppp.entity.Product;
import ru.malikkkz.SpringShoppp.entity.Review;
import ru.malikkkz.SpringShoppp.entity.User;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Review findByUserAndProduct(User user, Product product);
}
