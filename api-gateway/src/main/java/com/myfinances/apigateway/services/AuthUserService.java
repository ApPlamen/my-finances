package com.myfinances.apigateway.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myfinances.apigateway.model.entities.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Optional;

@Service
public class AuthUserService {
    private final RestClient restClient;
    private final String baseUrl = "http://localhost:8083/api/users";

    AuthUserService() {
        restClient = RestClient.create();//.builder().baseUrl(baseUrl).build();
    }

    public Optional<User> findUserByUserName(String userName) {
        String result = restClient.get()
                .uri("http://localhost:8083/api/users/findUserByUserName/" + userName)
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
