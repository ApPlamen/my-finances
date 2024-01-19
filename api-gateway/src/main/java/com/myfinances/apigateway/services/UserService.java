package com.myfinances.apigateway.services;

import com.myfinances.apigateway.dtos.inputs.UserInputDTO;
import com.myfinances.apigateway.dtos.inputs.UserUpdateDTO;
import com.myfinances.apigateway.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Optional;

@Service
public class UserService {
    private final RestClient restClient;

    UserService(@Value("${users.service.baseUrl}") String baseUrl) {
        restClient = RestClient.builder().baseUrl(baseUrl + "users").build();
    }

    public Optional<User> findUserByUserName(String userName) {
        User result = restClient.get()
                .uri("/findUserByUserName/" + userName)
                .retrieve()
                .body(User.class);

        return result != null ? Optional.of(result) : Optional.empty();
    }

    public User create(UserInputDTO user) {
        User result = restClient.post()
                .uri("/create")
                .body(user)
                .retrieve()
                .body(User.class);

        return result;
    }

    public User update(UserUpdateDTO user) {
        User result = restClient.put()
                .uri("/update")
                .body(user)
                .retrieve()
                .body(User.class);

        return result;
    }
}
