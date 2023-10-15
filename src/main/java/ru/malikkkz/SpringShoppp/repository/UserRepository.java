package ru.malikkkz.SpringShoppp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.malikkkz.SpringShoppp.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
}
