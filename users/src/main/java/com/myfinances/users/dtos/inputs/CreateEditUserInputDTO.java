package com.myfinances.users.dtos.inputs;

import com.myfinances.users.entities.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class CreateEditUserInputDTO extends UpdateDTO<User, Optional<Integer>> {
    private String userName;
    private String fullName;
    private String newPassword;

    @Override
    public User toEntity(User user) {
        user.setUserName(this.getUserName());
        user.setFullName(this.getFullName());

        if (!this.getNewPassword().isEmpty()) {
            user.setPassword(this.getNewPassword());
        }

        return user;
    }
}
