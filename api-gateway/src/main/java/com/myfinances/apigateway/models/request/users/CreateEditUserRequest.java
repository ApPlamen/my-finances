package com.myfinances.apigateway.models.request.users;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class CreateEditUserRequest {
    private Optional<Integer> id;
    @NotBlank
    private String userName;
    @NotBlank
    private String fullName;
    private String newPassword;
    private List<Integer> roles;
}
