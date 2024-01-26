package com.myfinances.users.infrastructure;

import com.myfinances.users.entities.Authority;
import com.myfinances.users.entities.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorityRepo extends Repo<Authority, Integer> {
    public Optional<Authority> findByName(String name);
}
