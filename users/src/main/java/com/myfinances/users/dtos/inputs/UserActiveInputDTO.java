package com.myfinances.users.dtos.inputs;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserActiveInputDTO {
    @NotBlank
    private int userId;
    @NotBlank
    private boolean active;
}
