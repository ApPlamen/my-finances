package com.myfinances.apigateway.model.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int id;
    private String userName;
    private String password;
    private boolean active;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
