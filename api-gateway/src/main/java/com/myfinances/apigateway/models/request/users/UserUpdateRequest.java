package com.myfinances.apigateway.models.request.users;

import com.myfinances.apigateway.models.request.UpdateRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateRequest extends UpdateRequest<Integer> {

    private String userName;
    private String fullName;
    private String password;
    private boolean active;

}
