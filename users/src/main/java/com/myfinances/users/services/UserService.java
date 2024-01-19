package com.myfinances.users.services;

import com.myfinances.users.dtos.inputs.UserInputDTO;
import com.myfinances.users.dtos.inputs.UserUpdateDTO;
import com.myfinances.users.dtos.views.AuthUserView;
import com.myfinances.users.entities.User;
import com.myfinances.users.infrastructure.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends CRUDService<User, Integer, UserInputDTO, UserUpdateDTO> {
    private final UserRepo repo;

    @Autowired
    public UserService(UserRepo repo) {
        super(repo);
        this.repo = repo;
    }

    public Optional<AuthUserView> findUserByUserName(String userName) {
        Optional<User> result = repo.findByUserName(userName);

        if (result.isEmpty()) {
            return Optional.empty();
        }

        User user = result.get();
        AuthUserView authUserView = new AuthUserView(user.getUserName(), user.getPassword(), user.isActive());

        return Optional.of(authUserView);
    }
}
