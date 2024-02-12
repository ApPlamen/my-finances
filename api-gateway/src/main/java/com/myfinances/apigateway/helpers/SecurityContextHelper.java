package com.myfinances.apigateway.helpers;

import com.myfinances.apigateway.security.SecurityUser;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityContextHelper {
    public static int getUserId() {
        return ((SecurityUser) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal())
                .getId();
    }
}
