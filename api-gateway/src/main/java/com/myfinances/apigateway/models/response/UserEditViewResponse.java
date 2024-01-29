package com.myfinances.apigateway.models.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEditViewResponse {
    private int id;
    private String userName;
    private String fullName;
}
