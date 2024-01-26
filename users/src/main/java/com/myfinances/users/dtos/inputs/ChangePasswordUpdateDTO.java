package com.myfinances.users.dtos.inputs;

import com.myfinances.users.entities.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ChangePasswordUpdateDTO extends UpdateDTO<User, Integer> {
    private String currentPassword;
    private String newPassword;

    @Override
    public User toEntity(User entity) {
        entity.setPassword(newPassword);

        return entity;
    }
}
