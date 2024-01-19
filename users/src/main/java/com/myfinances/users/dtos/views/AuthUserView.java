package com.myfinances.users.dtos.views;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthUserView {
    private int id;
    private String userName;
    private String password;
    private boolean active;

    public AuthUserView(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public AuthUserView(String userName, String password, boolean active) {
        this(userName, password);
        this.active = active;
    }
}
