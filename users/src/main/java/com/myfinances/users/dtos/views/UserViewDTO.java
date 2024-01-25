package com.myfinances.users.dtos.views;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class UserViewDTO implements ViewDTO {
    private int id;
    private String userName;
    private String password;
    private boolean active;
    private List<AuthorityViewDTO> authorities;
}
