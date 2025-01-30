package com.example.grocerybooking.repository;

import com.example.grocerybooking.model.Role;
import com.example.grocerybooking.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    private final List<User> users = List.of(
            new User(1, "admin", "{noop}admin123", Role.ADMIN),
            new User(2, "user", "{noop}user123", Role.USER)
    );

    public User findByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }
}
