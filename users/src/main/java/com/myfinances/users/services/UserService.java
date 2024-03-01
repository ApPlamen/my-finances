package com.myfinances.users.services;

import com.myfinances.users.dtos.inputs.CreateEditUserInputDTO;
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

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
        return repo.findByUserName(userName)
                .map(this::toView);
    }

    public void register(RegisterInputDTO registerRequest) {
        User newUser = registerRequest.toEntity();

        Authority userAuthority = authorityService.getUserAuthority();
        newUser.setAuthorities(Set.of(userAuthority));

        this.repo.save(newUser);
    }

    public List<UserBoardItemViewDTO> getBoard() {
        return this.repo.getUserBoard();
    }

    public void setActive(UserActiveInputDTO request) {
        User user = this.repo.findById(request.getUserId()).orElseThrow();

        user.setActive(request.isActive());

        this.repo.save(user);
    }

    public UserEditViewDTO getEditUser(int userId) {
        return this.repo.findById(userId)
                .map(UserEditViewDTO::create)
                .orElseThrow();
    }

    public void createEditUser(CreateEditUserInputDTO request) {
        User user = request.getId().isPresent() ? this.repo.findById(request.getId().get()).orElse(new User()) : new User();
        User entity = request.toEntity(user);

        List<Authority> authorities = authorityService.findAllById(request.getRoles());
        entity.setAuthorities(new HashSet<>(authorities));

        this.repo.save(entity);
    }

    @Override
    protected UserViewDTO toView(User user) {
        List<AuthorityViewDTO> authorities = user.getAuthorities()
                .stream().map(this::getAuthorityView)
                .toList();

        return UserViewDTO.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .fullName(user.getFullName())
                .password(user.getPassword())
                .active(user.isActive())
                .authorities(authorities)
                .build();
    }

    private AuthorityViewDTO getAuthorityView(Authority authority) {
        return AuthorityViewDTO.builder()
                .id(authority.getId())
                .name(authority.getName())
                .build();
    }
}
