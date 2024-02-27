package com.myfinances.users.dtos.inputs;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserActiveInputDTO {
    @NotNull
    private int userId;
    @NotNull
    private boolean active;
}
