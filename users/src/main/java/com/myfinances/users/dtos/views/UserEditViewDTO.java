package com.myfinances.users.dtos.views;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserEditViewDTO {
    private int id;
    private String userName;
    private String fullName;
}
