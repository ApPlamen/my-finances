package com.myfinances.apigateway.services;

import com.myfinances.apigateway.models.response.users.RolesOptionResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityService extends BaseRestService {
    public AuthorityService(@Value("${users.service.baseUrl}") String baseUrl) {
        super(baseUrl, "authorities");
    }

    public List<RolesOptionResponse> getRolesOptions() {
        return restClient.get()
                .uri("/options-roles")
                .retrieve()
                .body(List.class);
    }
}
