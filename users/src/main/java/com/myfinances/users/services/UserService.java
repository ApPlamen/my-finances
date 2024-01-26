package com.myfinances.users.services;

import com.myfinances.users.dtos.inputs.RegisterInputDTO;
import com.myfinances.users.dtos.inputs.UserInputDTO;
import com.myfinances.users.dtos.inputs.UserUpdateDTO;
import com.myfinances.users.dtos.views.AuthorityViewDTO;
import com.myfinances.users.dtos.views.UserViewDTO;
import com.myfinances.users.entities.Authority;
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

    public Optional<UserViewDTO> findUserByUserName(String userName) {
        Optional<User> result = repo.findByUserName(userName);

        return result.map(user -> toView(user));
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
                .stream().map(authority -> getAuthorityView(authority))
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

    private AuthorityViewDTO getAuthorityView(Authority authority) {
        return AuthorityViewDTO.builder()
                .id(authority.getId())
                .name(authority.getName())
                .build();
    }

    public void register(RegisterInputDTO registerRequest) {
        User newUser = registerRequest.toEntity();
        this.repo.save(newUser);
    }
}
