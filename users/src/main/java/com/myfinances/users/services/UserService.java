package com.myfinances.users.services;

import com.myfinances.users.dtos.inputs.UserInputDTO;
import com.myfinances.users.dtos.inputs.UserUpdateDTO;
import com.myfinances.users.dtos.views.AuthUserView;
import com.myfinances.users.dtos.views.AuthorityViewDTO;
import com.myfinances.users.dtos.views.UserViewDTO;
import com.myfinances.users.entities.User;
import com.myfinances.users.infrastructure.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService extends CRUDService<User, Integer, UserInputDTO, UserUpdateDTO, UserViewDTO> {
    private final UserRepo repo;

    public UserService(UserRepo repo) {
        super(repo);
        this.repo = repo;
    }

    public Optional<AuthUserView> findUserByUserName(String userName) {
        Optional<User> result = repo.findByUserName(userName);

        if (result.isEmpty()) {
            return Optional.empty();
        }

        User user = result.get();
        AuthUserView authUserView = new AuthUserView(user.getUserName(), user.getPassword(), user.isActive());

        return Optional.of(authUserView);
    }

    @Override
    public void deleteById(Integer userId) {
        User user = this.repo.findById(userId).get();
        user.setActive(false);
        this.repo.save(user);
    }

    @Override
    protected UserViewDTO toView(User user) {
        List<AuthorityViewDTO> authorities = user.getAuthorities()
                .stream().map(authority ->
                        AuthorityViewDTO.builder()
                                .id(authority.getId())
                                .name(authority.getName())
                                .build())
                .toList();

        UserViewDTO view = UserViewDTO.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .password(user.getPassword())
                .active(user.isActive())
                .authorities(authorities)
                .build();

        return view;
    }
}
