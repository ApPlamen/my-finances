package com.myfinances.apigateway.models.request.users;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    @NotBlank
    private String userName;
    @NotBlank
    private String fullName;
    @NotBlank
    @Size(min = 6)
    private String password;
}
