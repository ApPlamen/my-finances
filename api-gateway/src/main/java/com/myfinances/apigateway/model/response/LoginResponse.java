package com.myfinances.apigateway.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    private String userName;
    private String token;

    public LoginResponse(String userName, String token) {
        this.userName = userName;
        this.token = token;
    }
}
