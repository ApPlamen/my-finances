package com.myfinances.apigateway.models.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateRequest extends UpdateRequest<Integer> {

    private String userName;
    private String password;
    private boolean active;

}
