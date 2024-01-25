package com.myfinances.apigateway.services;

import com.myfinances.apigateway.security.models.SecurityUser;
import com.myfinances.apigateway.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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

        return user.map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found" + userName));
    }
}
