package com.myfinances.users.dtos.views;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AuthorityViewDTO implements ViewDTO {
    private int id;
    private String name;
}
