package com.myfinances.apigateway.repositories;

import com.myfinances.apigateway.model.entities.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<User>(
            Arrays.asList(
                    new User("admin", "pass", true),
                    new User("admin1", "pass1", false))
    );

    public User findUserByUserName(String userName) {
        User user = users.stream()
                .filter(u -> userName.equals(u.getUserName()))
                .findAny()
                .orElse(null);
        return user;
    }
}
