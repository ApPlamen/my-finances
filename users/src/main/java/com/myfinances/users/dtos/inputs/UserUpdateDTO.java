package com.myfinances.users.dtos.inputs;

import com.myfinances.users.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDTO extends UpdateDTO<User, Integer> {

    private String userName;
    private String password;
    private boolean active;

    @Override
    public User toEntity(User entity) {
        entity.setId(this.getId());
        entity.setUserName(this.getUserName());
        entity.setPassword(this.getPassword());
        entity.setActive(this.isActive());

        return entity;
    }

}
