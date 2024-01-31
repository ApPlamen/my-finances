package com.myfinances.apigateway.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class ClaimAuthority implements GrantedAuthority {
    private final String authorityName;

    @Override
    public String getAuthority() {
        return authorityName;
    }
}
