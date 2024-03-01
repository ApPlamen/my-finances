package com.myfinances.users.dtos.views;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBoardItemViewDTO {
    private int id;
    private String userName;
    private String fullName;
    private boolean active;
    private String[] roles;
}
