package com.myfinances.apigateway.controllers;

import com.myfinances.apigateway.models.request.UserInputRequest;
import com.myfinances.apigateway.models.request.UserUpdateRequest;
import com.myfinances.apigateway.entities.User;
import com.myfinances.apigateway.models.response.UserViewResponse;
import com.myfinances.apigateway.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Users Controller")
public class UserController extends CRUDController<User, Integer, UserInputRequest, UserUpdateRequest, UserViewResponse> {
    private final UserService userService;

    public UserController(UserService userService) {
        super(userService);
        this.userService = userService;
    }
}
