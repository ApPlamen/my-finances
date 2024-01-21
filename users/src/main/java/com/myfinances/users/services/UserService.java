package com.myfinances.users.services;

import com.myfinances.users.dtos.inputs.UserInputDTO;
import com.myfinances.users.dtos.inputs.UserUpdateDTO;
import com.myfinances.users.entities.User;
import com.myfinances.users.infrastructure.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CRUDService<User, Integer, UserInputDTO, UserUpdateDTO> {

    @Autowired
    public UserService(UserRepo repo) {
        super(repo);
    }
}
