package com.myfinances.users.entities;

import com.myfinances.users.dtos.views.UserBoardItemViewDTO;
import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "Users")
@Getter
@Setter
@SqlResultSetMapping(name = "UserBoard", classes = {
        @ConstructorResult(targetClass = UserBoardItemViewDTO.class,
                columns = {
                        @ColumnResult(name = "id"),
                        @ColumnResult(name = "userName"),
                        @ColumnResult(name = "fullName"),
                        @ColumnResult(name = "active"),
                        @ColumnResult(name = "roles")
                })
})
public class User implements EntityModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "fullName")
    private String fullName;
    @Column(name = "password")
    private String password;
    @Column(name = "active")
    private boolean active;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_authorities",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "authorityId"))
    private Set<Authority> authorities;
}
