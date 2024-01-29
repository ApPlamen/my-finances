package com.myfinances.users.services;

import com.myfinances.users.dtos.inputs.RegisterInputDTO;
import com.myfinances.users.dtos.inputs.UserActiveInputDTO;
import com.myfinances.users.dtos.inputs.UserInputDTO;
import com.myfinances.users.dtos.inputs.UserUpdateDTO;
import com.myfinances.users.dtos.views.AuthorityViewDTO;
import com.myfinances.users.dtos.views.UserBoardItemViewDTO;
import com.myfinances.users.dtos.views.UserEditViewDTO;
import com.myfinances.users.dtos.views.UserViewDTO;
import com.myfinances.users.entities.Authority;
import com.myfinances.users.entities.User;
import com.myfinances.users.infrastructure.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService extends CRUDService<User, Integer, UserInputDTO, UserUpdateDTO, UserViewDTO> {
    private final UserRepo repo;
    private final AuthorityService authorityService;

    public UserService(UserRepo repo, AuthorityService authorityService) {
        super(repo);
        this.repo = repo;
        this.authorityService = authorityService;
    }

    public Optional<UserViewDTO> findUserByUserName(String userName) {
        Optional<User> result = repo.findByUserName(userName);

        return result.map(this::toView);
    }

    public void register(RegisterInputDTO registerRequest) {
        User newUser = registerRequest.toEntity();
        Authority userAuthority = authorityService.getUserAuthority();
        newUser.setAuthorities(Set.of(userAuthority));
        this.repo.save(newUser);
    }

    public List<UserBoardItemViewDTO> getBoard() {
        List<UserBoardItemViewDTO> board = this.repo.findAllByOrderByIdAsc().stream()
                .map(UserBoardItemViewDTO::create)
                .collect(Collectors.toList());

        return board;
    }

    public void setActive(UserActiveInputDTO request) {
        User user = this.repo.findById(request.getUserId()).get();

        user.setActive(request.isActive());

        this.repo.save(user);
    }

    public UserEditViewDTO getEditUser(int userId) {
        UserEditViewDTO user = this.repo.findById(userId)
                .map(UserEditViewDTO::create)
                .get();

        return user;
    }

    @Override
    protected UserViewDTO toView(User user) {
        List<AuthorityViewDTO> authorities = user.getAuthorities()
                .stream().map(this::getAuthorityView)
                .toList();

        UserViewDTO view = UserViewDTO.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .fullName(user.getFullName())
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
}
