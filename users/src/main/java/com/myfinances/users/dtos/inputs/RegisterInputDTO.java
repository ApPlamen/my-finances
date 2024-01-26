package com.myfinances.users.dtos.inputs;

import com.myfinances.users.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterInputDTO extends InputDTO<User> {
    private String userName;
    private String fullName;
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
