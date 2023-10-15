package ru.malikkkz.SpringShoppp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.malikkkz.SpringShoppp.entity.User;
import ru.malikkkz.SpringShoppp.repository.UserRepository;
import ru.malikkkz.SpringShoppp.security.UserDetail;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getCurrentUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        return  userRepository.findByLogin(authentication.getName()).orElse(null);
    }

}
