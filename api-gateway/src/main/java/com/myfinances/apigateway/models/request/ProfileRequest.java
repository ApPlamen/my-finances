package com.myfinances.apigateway.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileRequest {
    @NotBlank
    private String fullName;
}
