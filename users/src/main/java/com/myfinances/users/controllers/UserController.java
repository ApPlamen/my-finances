package com.myfinances.users.controllers;

import com.myfinances.users.dtos.inputs.UserInputDTO;
import com.myfinances.users.dtos.inputs.UserUpdateDTO;
import com.myfinances.users.dtos.views.AuthUserView;
import com.myfinances.users.entities.User;
import com.myfinances.users.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController extends CRUDController<User, Integer, UserInputDTO, UserUpdateDTO> {

    private final UserService service;

    public UserController(UserService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("findUserByUserName/{userName}")
    public ResponseEntity<Optional<AuthUserView>> findUserByUserName(@PathVariable String userName) {
        Optional<AuthUserView> authUserView = service.findUserByUserName(userName);
        return ResponseEntity.ok(authUserView);
    }
}
