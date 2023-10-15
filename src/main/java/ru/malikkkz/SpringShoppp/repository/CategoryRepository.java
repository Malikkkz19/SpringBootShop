package ru.malikkkz.SpringShoppp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.malikkkz.SpringShoppp.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
