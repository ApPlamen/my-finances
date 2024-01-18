package com.myfinances.users.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface Repo<entity, idType> extends JpaRepository<entity, idType> {

}
