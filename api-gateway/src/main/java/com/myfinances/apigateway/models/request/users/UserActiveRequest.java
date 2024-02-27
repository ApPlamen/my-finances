package com.myfinances.apigateway.models.request.users;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserActiveRequest {
    @NotNull
    private int userId;
    @NotNull
    private boolean active;
}
