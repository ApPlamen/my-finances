package com.myfinances.apigateway.services;

import com.myfinances.apigateway.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userService.findUserByUserName(userName);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Username Not Found");
        }

        List<String> roles = new ArrayList<>();
        roles.add("USER");
        UserDetails userDetails =
                org.springframework.security.core.userdetails.User.builder()
                        .username(user.get().getUserName())
                        .password(user.get().getPassword())
                        .disabled(!user.get().isActive())
                        .roles(roles.toArray(new String[0]))
                        .build();
        return userDetails;
    }
}
