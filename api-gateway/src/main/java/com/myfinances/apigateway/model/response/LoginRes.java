package com.myfinances.apigateway.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRes {
    private String userName;
    private String token;

    public LoginRes(String userName, String token) {
        this.userName = userName;
        this.token = token;
    }
}
