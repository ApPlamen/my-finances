package com.myfinances.apigateway.models.request.users;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserActiveRequest {
    @NotBlank
    private int userId;
    @NotBlank
    private boolean active;
}
