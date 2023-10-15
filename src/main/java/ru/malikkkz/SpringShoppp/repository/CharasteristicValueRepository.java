package ru.malikkkz.SpringShoppp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.malikkkz.SpringShoppp.entity.Charasteristic;
import ru.malikkkz.SpringShoppp.entity.CharasteristicValue;

public interface CharasteristicValueRepository extends JpaRepository<CharasteristicValue, Long> {
}
