package com.myfinances.apigateway.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class User implements EntityModel {
    private int id;
    private String userName;
    private String password;
    private boolean active;
    private List<Authority> authorities;
}
