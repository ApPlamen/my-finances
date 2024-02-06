package com.myfinances.apigateway.controllers;

import com.myfinances.apigateway.models.request.users.CreateEditUserRequest;
import com.myfinances.apigateway.models.request.users.UserActiveRequest;
import com.myfinances.apigateway.models.request.users.UserInputRequest;
import com.myfinances.apigateway.models.request.users.UserUpdateRequest;
import com.myfinances.apigateway.entities.User;
import com.myfinances.apigateway.models.response.users.UserBoardItemResponse;
import com.myfinances.apigateway.models.response.users.UserEditViewResponse;
import com.myfinances.apigateway.models.response.users.UserViewResponse;
import com.myfinances.apigateway.configs.OpenAPI30Config;
import com.myfinances.apigateway.services.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
@Tag(name = "Users Controller")
@SecurityRequirement(name = OpenAPI30Config.securitySchemeName)
public class UserController extends CRUDController<User, Integer, UserInputRequest, UserUpdateRequest, UserViewResponse> {
    private final UserService service;

    public UserController(UserService userService) {
        super(userService);
        this.service = userService;
    }

    @GetMapping("board")
    public ResponseEntity<List<UserBoardItemResponse>> getBoard() {
        List<UserBoardItemResponse> response = this.service.getBoard();
        return ResponseEntity.ok(response);
    }

    @PostMapping("set-active")
    public void setActive(@RequestBody UserActiveRequest request) {
        this.service.setActive(request);
    }

    @GetMapping("get-edit/{userId}")
    public ResponseEntity<UserEditViewResponse> getById(@PathVariable int userId) {
        UserEditViewResponse response = this.service.getEditUser(userId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("create-edit-user")
    public void createEditUser(@Valid @RequestBody CreateEditUserRequest request) {
        this.service.createEditUser(request);
    }
}
