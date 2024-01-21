package com.myfinances.apigateway.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User implements EntityModel {
    private int id;
    private String userName;
    private String password;
    private boolean active;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String password, boolean active) {
        this(userName, password);
        this.active = active;
    }
}
