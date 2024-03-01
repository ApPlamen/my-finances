package com.myfinances.users.infrastructure;

import com.myfinances.users.dtos.views.UserBoardItemViewDTO;

import java.util.List;

public interface CustomUserRepo {
    public List<UserBoardItemViewDTO> getUserBoard();
}
