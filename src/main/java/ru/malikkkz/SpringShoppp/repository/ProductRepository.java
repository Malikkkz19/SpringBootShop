package ru.malikkkz.SpringShoppp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.malikkkz.SpringShoppp.entity.Category;
import ru.malikkkz.SpringShoppp.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(Category category);

    @Override
    <S extends Product> S save(S entity);

    @Override
    void delete(Product entity);
}
