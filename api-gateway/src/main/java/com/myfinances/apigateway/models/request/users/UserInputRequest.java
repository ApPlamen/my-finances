package com.myfinances.apigateway.models.request.users;

import com.myfinances.apigateway.models.request.InputRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInputRequest extends InputRequest {

    private String userName;
    private String fullName;
    private String password;

}
