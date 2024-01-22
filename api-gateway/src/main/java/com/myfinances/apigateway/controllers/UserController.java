package com.myfinances.apigateway.controllers;

import com.myfinances.apigateway.model.request.UserInputRequest;
import com.myfinances.apigateway.model.request.UserUpdateRequest;
import com.myfinances.apigateway.entities.User;
import com.myfinances.apigateway.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<User> create(@RequestBody UserInputRequest user) {
        User userResponse = this.userService.create(user);
        return ResponseEntity.ok(userResponse);
    }

    @PutMapping("update")
    public ResponseEntity<User> update(@RequestBody UserUpdateRequest user) {
        User userResponse =  this.userService.update(user);
        return ResponseEntity.ok(userResponse);
    }

    @DeleteMapping("delete/{userId}")
    public void deleteById(@PathVariable int userId) {
        this.userService.deleteById(userId);
    }
}
