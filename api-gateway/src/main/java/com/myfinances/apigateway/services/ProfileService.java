package com.myfinances.apigateway.services;

import com.myfinances.apigateway.models.response.ProfileResponse;
import com.myfinances.apigateway.security.models.SecurityUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ProfileService {
    private final RestClient restClient;

    public ProfileService(@Value("${users.service.baseUrl}") String baseUrl) {
        restClient = RestClient.builder().baseUrl(baseUrl + "profile").build();
    }

    public ProfileResponse getProfile() {
        int userId = ((SecurityUser) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal())
                .getId();

        ProfileResponse result = restClient.get()
                .uri("/" + userId)
                .retrieve()
                .body(ProfileResponse.class);

        return result;
    }
}
