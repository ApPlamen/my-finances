package com.myfinances.users.dtos.inputs;

import com.myfinances.users.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInputDTO extends InputDTO<User> {

    private String userName;
    private String fullName;
    private String password;

    @Override
    public User toEntity() {
        User userEntity = new User();
        userEntity.setUserName(this.getUserName());
        userEntity.setFullName(this.getFullName());
        userEntity.setPassword(this.getPassword());
        userEntity.setActive(true);

        return userEntity;
    }

}
