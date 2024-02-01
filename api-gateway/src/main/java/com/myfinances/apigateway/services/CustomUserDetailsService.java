package com.myfinances.apigateway.services;

import com.myfinances.apigateway.security.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userService.findUserByUserName(userName)
                .map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found" + userName));
    }
}
