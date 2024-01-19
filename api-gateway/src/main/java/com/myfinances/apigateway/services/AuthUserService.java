package com.myfinances.apigateway.services;

import com.myfinances.apigateway.model.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Optional;

@Service
public class AuthUserService {
    private final RestClient restClient;

    AuthUserService(@Value("${users.service.baseUrl}") String baseUrl) {
        restClient = RestClient.builder().baseUrl(baseUrl + "users").build();
    }

    public Optional<User> findUserByUserName(String userName) {
        User result = restClient.get()
                .uri("/findUserByUserName/" + userName)
                .retrieve()
                .body(User.class);

        return result != null ? Optional.of(result) : Optional.empty();
    }
}
