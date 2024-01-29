package com.myfinances.users.infrastructure;

import com.myfinances.users.dtos.views.UserBoardItemViewDTO;
import com.myfinances.users.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface UserRepo extends Repo<User, Integer> {

    public Optional<User> findByUserName(String userName);

    @Query(
            value = """
                    select
                    	u.id as id,
                    	u.user_name as userName,
                    	u.full_name as fullName,
                    	u.active as active,
                    	array_agg(a."name"), ', ' as roles
                    from
                    	users as u
                        join users_authorities as ua
                                on u.id = ua.user_id
                        join
                        	(select id, "name"
                        	from authorities
                        	where "name" like 'ROLE_%') as a
                                on ua.authority_id = a.id
                    group by
                        u.id, u.user_name, u.full_name, u.active
                    """,
            nativeQuery = true)
    Collection getBoard();

}
