package com.myfinances.users.dtos.views;

import com.myfinances.users.entities.User;
import com.myfinances.users.entities.Authority;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserBoardItemViewDTO {
    private int id;
    private String userName;
    private String fullName;
    private boolean active;
    private List<String> roles;

    public static UserBoardItemViewDTO create(User user) {
        UserBoardItemViewDTO dto = new UserBoardItemViewDTO();

        List<String> roles = user.getAuthorities()
                .stream()
                .map(Authority::getName)
                .filter(r -> r.startsWith("ROLE_"))
                .map(r -> r.replace("ROLE_", ""))
                .toList();

        dto.setId(user.getId());
        dto.setUserName(user.getUserName());
        dto.setFullName(user.getFullName());
        dto.setActive(user.isActive());
        dto.setRoles(roles);

        return dto;
    }
}
