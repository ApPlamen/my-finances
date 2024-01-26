package com.myfinances.apigateway.models.internal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProfileInternalRequest {
    private int id;
    private String fullName;
}
