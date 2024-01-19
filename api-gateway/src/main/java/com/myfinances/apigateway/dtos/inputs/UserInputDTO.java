package com.myfinances.apigateway.dtos.inputs;

import com.myfinances.apigateway.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInputDTO extends InputDTO<User> {

    private String userName;
    private String password;

    @Override
    public User toEntity() {
        User userEntity = new User();
        userEntity.setUserName(this.getUserName());
        userEntity.setPassword(this.getPassword());
        userEntity.setActive(true);

        return userEntity;
    }

}
