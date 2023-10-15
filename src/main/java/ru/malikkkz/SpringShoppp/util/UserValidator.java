package ru.malikkkz.SpringShoppp.util;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.executable.ExecutableValidator;
import jakarta.validation.metadata.BeanDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.malikkkz.SpringShoppp.entity.User;
import ru.malikkkz.SpringShoppp.service.UserDetailService;

import java.util.Set;

@Component
public class UserValidator implements Validator {


    private final UserDetailService userDetailService;

    public UserValidator(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        User user = (User) target;

        try {
            userDetailService.loadUserByUsername(user.getLogin());
        } catch (UsernameNotFoundException ignored) {
            return;
        }


        errors.rejectValue("login", ""
                , "Человек с таким логином уже существует");
    }
}
