package com.myfinances.apigateway.models.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class CreateEditUserRequest {
    private Optional<Integer> id;
    private String userName;
    private String fullName;
    private String newPassword;
    private List<Integer> roles;
}
