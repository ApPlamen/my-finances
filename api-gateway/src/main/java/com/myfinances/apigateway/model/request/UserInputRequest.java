package com.myfinances.apigateway.model.request;

import com.myfinances.apigateway.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInputRequest extends InputRequest<User> {

    private String userName;
    private String password;

}
