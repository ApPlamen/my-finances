package com.myfinances.apigateway.models.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserActiveRequest {
    private int userId;
    private boolean active;
}
