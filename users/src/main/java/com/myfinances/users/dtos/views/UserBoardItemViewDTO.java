package com.myfinances.users.dtos.views;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class UserBoardItemViewDTO {
    private int id;
    private String userName;
    private String fullName;
    private boolean active;
    private List<String> roles;
}
