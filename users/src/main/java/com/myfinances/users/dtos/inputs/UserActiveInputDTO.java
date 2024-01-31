package com.myfinances.users.dtos.inputs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserActiveInputDTO {
    private int userId;
    private boolean active;
}
