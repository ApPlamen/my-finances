package com.myfinances.apigateway.services;

import com.myfinances.apigateway.models.response.RolesOptionResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityService extends BaseRestService {
    AuthorityService(@Value("${users.service.baseUrl}") String baseUrl) {
        super(baseUrl, "authorities");
    }

    public List<RolesOptionResponse> getRolesOptions() {
        List result = restClient.get()
                .uri("/options-roles")
                .retrieve()
                .body(List.class);

        return result;
    }
}
