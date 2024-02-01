package com.myfinances.users.dtos.inputs;

import com.myfinances.users.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ChangePasswordUpdateDTO extends UpdateDTO<User, Integer> {
    @NotBlank
    @Size(min = 6)
    private String currentPassword;
    @NotBlank
    @Size(min = 6)
    private String newPassword;

    @Override
    public User toEntity(User entity) {
        entity.setPassword(newPassword);

        return entity;
    }
}
