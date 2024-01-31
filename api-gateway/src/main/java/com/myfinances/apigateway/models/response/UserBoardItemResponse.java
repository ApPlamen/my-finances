package com.myfinances.apigateway.models.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserBoardItemResponse {
    private int id;
    private String userName;
    private String fullName;
    private boolean active;
    private List<String> roles;
}
