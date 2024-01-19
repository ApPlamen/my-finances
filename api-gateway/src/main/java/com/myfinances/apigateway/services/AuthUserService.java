package com.myfinances.apigateway.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        String result = restClient.get()
                .uri("/findUserByUserName/" + userName)
                .retrieve()
                .body(String.class);

        ObjectMapper mapper = new ObjectMapper();
        User user;
        try {
            user = mapper.readValue(result, User.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return user != null ? Optional.of(user) : Optional.empty();
    }
}
