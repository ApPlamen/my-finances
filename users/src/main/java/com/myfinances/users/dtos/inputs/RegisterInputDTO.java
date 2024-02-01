package com.myfinances.users.dtos.inputs;

import com.myfinances.users.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterInputDTO extends InputDTO<User> {
    @NotBlank
    private String userName;
    @NotBlank
    private String fullName;
    @NotBlank
    @Size(min = 6)
    private String password;

    @Override
    public User toEntity() {
        User user = new User();
        user.setUserName(this.getUserName());
        user.setFullName(this.getFullName());
        user.setPassword(this.getPassword());
        user.setActive(true);

        return user;
    }
}
