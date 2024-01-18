package com.myfinances.apigateway.repositories;

import com.myfinances.apigateway.model.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public User findUserByEmail(String email) {
        User user = new User("admin", "pass");
        user.setActive(true);
        return user;
    }
}
