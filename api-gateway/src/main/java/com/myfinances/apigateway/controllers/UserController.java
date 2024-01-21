package com.myfinances.apigateway.controllers;

import com.myfinances.apigateway.model.request.UserInputRequest;
import com.myfinances.apigateway.model.request.UserUpdateRequest;
import com.myfinances.apigateway.entities.User;
import com.myfinances.apigateway.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Users Controller")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("create")
    public User create(@RequestBody UserInputRequest user) {
        return this.userService.create(user);
    }

    @PutMapping("update")
    public User update(@RequestBody UserUpdateRequest user) {
        return this.userService.update(user);
    }

    @DeleteMapping("delete/{userId}")
    public void deleteById(@PathVariable int userId) {
        this.userService.deleteById(userId);
    }
}
