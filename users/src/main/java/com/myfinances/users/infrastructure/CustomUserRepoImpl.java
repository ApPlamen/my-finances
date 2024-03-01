package com.myfinances.users.infrastructure;

import com.myfinances.users.dtos.views.UserBoardItemViewDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

public class CustomUserRepoImpl implements CustomUserRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserBoardItemViewDTO> getUserBoard() {
        String sql = """
                SELECT u.id AS id, u.user_name AS userName, u.full_name AS fullName, u.active AS active,
                    array_agg(replace(a.name, 'ROLE_', '')) AS roles
                FROM users AS u
                JOIN users_authorities AS ua ON u.id = ua.user_id\s
                JOIN (SELECT id, name
                    FROM authorities
                    WHERE name LIKE 'ROLE_%') AS a ON ua.authority_id = a.id\s
                GROUP BY u.id, userName, fullName, active
                ORDER BY u.id;
                """;

        Query query = entityManager.createNativeQuery(sql, "UserBoard");

        return query.getResultList();
    }
}
