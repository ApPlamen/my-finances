package com.myfinances.apigateway.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginReq {
    private String userName;
    private String password;
}
