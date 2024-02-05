package com.myfinances.apigateway.models.internal.users;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ChangePasswordInternalRequest {
    private int id;
    private String currentPassword;
    private String newPassword;
}
