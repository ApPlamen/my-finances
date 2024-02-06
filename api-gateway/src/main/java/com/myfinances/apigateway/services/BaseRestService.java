package com.myfinances.apigateway.services;

import org.springframework.web.client.RestClient;

public abstract class BaseRestService {
    protected final RestClient restClient;

    public BaseRestService(String baseUrl, String controllerPath) {
        restClient = RestClient.builder()
                .baseUrl(baseUrl + controllerPath)
                .build();
    }
}
