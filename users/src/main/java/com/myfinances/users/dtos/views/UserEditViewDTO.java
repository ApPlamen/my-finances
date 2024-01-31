package com.myfinances.users.dtos.views;

import com.myfinances.users.entities.Authority;
import com.myfinances.users.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
@NoArgsConstructor
public class UserEditViewDTO {
    private int id;
    private String userName;
    private String fullName;
    private List<Integer> roles;

    public static UserEditViewDTO create(User user) {
        UserEditViewDTO dto = new UserEditViewDTO();

        dto.setId(user.getId());
        dto.setUserName(user.getUserName());
        dto.setFullName(user.getFullName());
        dto.setRoles(user.getAuthorities().stream()
                .map(Authority::getId)
                .collect(Collectors.toList()));

        return dto;
    }
}
