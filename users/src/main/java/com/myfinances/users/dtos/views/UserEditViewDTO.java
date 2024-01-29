package com.myfinances.users.dtos.views;

import com.myfinances.users.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class UserEditViewDTO {
    private int id;
    private String userName;
    private String fullName;

    public static UserEditViewDTO create(User user) {
        UserEditViewDTO dto = new UserEditViewDTO();

        dto.setId(user.getId());
        dto.setUserName(user.getUserName());
        dto.setFullName(user.getFullName());

        return dto;
    }
}
