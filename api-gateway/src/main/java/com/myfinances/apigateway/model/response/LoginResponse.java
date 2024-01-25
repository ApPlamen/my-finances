package com.myfinances.apigateway.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {
    private String userName;
    private String token;
    private List<String> authorities;
}
