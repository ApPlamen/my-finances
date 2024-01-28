package com.myfinances.users.dtos.inputs;

import com.myfinances.users.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileUpdateDTO extends UpdateDTO<User, Integer> {
    private String fullName;

    @Override
    public User toEntity(User entity) {
        entity.setFullName(this.fullName);

        return entity;
    }
}
