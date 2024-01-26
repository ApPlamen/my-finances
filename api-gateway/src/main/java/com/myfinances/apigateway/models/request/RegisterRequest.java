package com.myfinances.apigateway.models.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String userName;
    private String fullName;
    private String password;
}
