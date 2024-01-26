package com.myfinances.users.services;

import com.myfinances.users.entities.Authority;
import com.myfinances.users.infrastructure.AuthorityRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorityService {
    private final AuthorityRepo repo;

    public Optional<Authority> getAuthority(String name) {
        return this.repo.findByName(name);
    }

    public Authority getUserAuthority() {
        return this.getAuthority("ROLE_USER").get();
    }
}
