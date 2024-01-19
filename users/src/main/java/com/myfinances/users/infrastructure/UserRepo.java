package com.myfinances.users.infrastructure;

import com.myfinances.users.entities.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends Repo<User, Integer> {

    public Optional<User> findByUserName(String userName);

}
