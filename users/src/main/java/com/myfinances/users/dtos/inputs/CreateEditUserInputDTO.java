package com.myfinances.users.dtos.inputs;

import com.myfinances.users.entities.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class CreateEditUserInputDTO extends UpdateDTO<User, Optional<Integer>> {
    @NotBlank
    private String userName;
    @NotBlank
    private String fullName;
    private String newPassword;
    private List<Integer> roles;

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
