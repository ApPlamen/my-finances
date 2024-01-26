package com.myfinances.apigateway.models.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserViewResponse extends ViewResponse {
    private int id;
    private String userName;
    private String password;
    private boolean active;
    private List<AuthorityViewResponse> authorities;
}
