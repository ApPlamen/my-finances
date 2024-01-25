package com.myfinances.apigateway.models.request;

import com.myfinances.apigateway.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateRequest extends UpdateRequest<User, Integer> {

    private String userName;
    private String password;
    private boolean active;

}
