package com.myfinances.users.controllers;

import com.myfinances.users.dtos.inputs.RegisterInputDTO;
import com.myfinances.users.dtos.inputs.UserInputDTO;
import com.myfinances.users.dtos.inputs.UserUpdateDTO;
import com.myfinances.users.dtos.views.UserViewDTO;
import com.myfinances.users.entities.User;
import com.myfinances.users.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController extends CRUDController<User, Integer, UserInputDTO, UserUpdateDTO, UserViewDTO> {

    private final UserService service;

    public UserController(UserService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("findUserByUserName/{userName}")
    public ResponseEntity<Optional<UserViewDTO>> findUserByUserName(@PathVariable String userName) {
        Optional<UserViewDTO> authUserView = service.findUserByUserName(userName);
        return ResponseEntity.ok(authUserView);
    }

    @PostMapping("register")
    public void register(@RequestBody RegisterInputDTO registerRequest) {
        this.service.register(registerRequest);
    }
}
