package com.myfinances.apigateway.controllers;

import com.myfinances.apigateway.models.request.UserInputRequest;
import com.myfinances.apigateway.models.request.UserUpdateRequest;
import com.myfinances.apigateway.entities.User;
import com.myfinances.apigateway.models.response.UserBoardItemResponse;
import com.myfinances.apigateway.models.response.UserViewResponse;
import com.myfinances.apigateway.configs.OpenAPI30Config;
import com.myfinances.apigateway.services.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
