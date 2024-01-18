package com.myfinances.users.infrastructure;

import com.myfinances.users.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends Repo<User, Integer> {

}
